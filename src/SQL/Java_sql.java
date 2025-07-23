package com.mycompany.java_sql;

import java.sql.*;
import java.util.Scanner;

// Asegúrate de importar esta clase o que esté en el mismo paquete
import com.mycompany.java_sql.UserMediaRegistry;

public class Java_sql {

    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();

        if (conn == null) {
            System.out.println("❌ No se pudo establecer conexión.");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("✅ Conexión exitosa.");

            while (true) {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Registrar usuario");
                System.out.println("2. Ver cantidad de usuarios");
                System.out.println("3. Salir");
                System.out.println("4. Iniciar sesión");
                System.out.println("5. Eliminar usuario");
                System.out.println("6. Gestionar registros multimedia");
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
        case 1:
            registrarUsuario(conn, scanner);
            break;
        case 2:
            mostrarCantidadUsuarios(conn);
            break;
        case 3:
            conn.close();
            System.out.println("👋 Adiós.");
            return;
        case 4:
            iniciarSesion(conn, scanner);
            break;
        case 5:
            eliminarUsuario(conn, scanner); // corregido también aquí
            break;
        case 6:
            UserMediaRegistry.agregarRegistro(conn, scanner);
            break;
        case 7:
            System.out.print("Ingrese ID de usuario para listar sus registros: ");
            int usuarioId = Integer.parseInt(scanner.nextLine());
            UserMediaRegistry.listarRegistros(conn, usuarioId);
            break;
        default:
            System.out.println("❌ Opción inválida.");
    }
            }

        } catch (SQLException e) {
            System.out.println("❌ Error en operación SQL: " + e.getMessage());
        }
    }

    public static void registrarUsuario(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Ingresa nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa contraseña: ");
        String password = scanner.nextLine();

        String sql = "INSERT INTO Usuario (nombre, password) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, password);
        stmt.executeUpdate();
        stmt.close();

        System.out.println("✅ Usuario registrado correctamente.");
    }

    public static void mostrarCantidadUsuarios(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) AS total FROM Usuario";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            int total = rs.getInt("total");
            System.out.println("👥 Total de usuarios: " + total);
        }

        rs.close();
        stmt.close();
    }

    public static void eliminarUsuario(Connection conn, Scanner sc) throws SQLException {
        System.out.print("🔒 Ingresa el nombre de usuario a eliminar: ");
        String nombre = sc.nextLine();

        String sql = "DELETE FROM Usuario WHERE nombre = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nombre);

        int filasAfectadas = stmt.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("✅ Usuario eliminado exitosamente.");
        } else {
            System.out.println("⚠️ No se encontró el usuario.");
        }

        stmt.close();
    }

    public static void iniciarSesion(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Nombre de usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        String sql = "SELECT COUNT(*) FROM Usuario WHERE nombre = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        rs.next();
        int count = rs.getInt(1);
        rs.close();
        stmt.close();

        if (count > 0) {
            System.out.println("✅ Inicio de sesión exitoso. Bienvenido, " + nombre + "!");
        } else {
            System.out.println("❌ Usuario o contraseña incorrectos.");
        }
    }
}
