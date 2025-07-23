
package com.mycompany.java_sql;

// Clase para manejar registros en UserMediaRegistry
import java.sql.*;
import java.util.Scanner;

public class UserMediaRegistry {

    public static void agregarRegistro(Connection conn, Scanner sc) {
        try {
            System.out.println("\n== Agregar nuevo registro de contenido multimedia ==");
            System.out.print("Nombre del contenido: ");
            String nombre = sc.nextLine();

            System.out.print("Rating (SIN_CALIFICACION, HORRIBLE, MALO, REGULAR, BUENO, MUY_BUENO, SUBLIME): ");
            String rating = sc.nextLine().toUpperCase();

            System.out.print("Estado (VIENDO, COMPLETADO, PENDIENTE, ABANDONADO, PLANIFICADO, REVISTO, NO_VISTO): ");
            String status = sc.nextLine().toUpperCase();

            System.out.print("¿Es favorito? (true/false): ");
            boolean favorito = Boolean.parseBoolean(sc.nextLine());

            System.out.print("Fecha de comienzo (YYYY-MM-DD): ");
            String fecha = sc.nextLine();

            System.out.print("URL de referencia (puede dejar en blanco): ");
            String url = sc.nextLine();

            System.out.print("ID de usuario asociado: ");
            int usuarioId = Integer.parseInt(sc.nextLine());

            String sql = "INSERT INTO UserMediaRegistry (nombre, rating, status, favorito, fecha_comienzo, reference_url, usuario_id) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, rating);
            stmt.setString(3, status);
            stmt.setBoolean(4, favorito);
            stmt.setDate(5, Date.valueOf(fecha));
            stmt.setString(6, url);
            stmt.setInt(7, usuarioId);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Registro agregado con éxito.");
            } else {
                System.out.println("❌ No se pudo agregar el registro.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public static void listarRegistros(Connection conn, int usuarioId) {
        try {
            String sql = "SELECT * FROM UserMediaRegistry WHERE usuario_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuarioId);

            ResultSet rs = stmt.executeQuery();
            System.out.println("\n📄 Registros del usuario ID: " + usuarioId);
            while (rs.next()) {
                System.out.println("- ID: " + rs.getInt("id") +
                        ", Nombre: " + rs.getString("nombre") +
                        ", Estado: " + rs.getString("status") +
                        ", Rating: " + rs.getString("rating") +
                        ", Favorito: " + rs.getBoolean("favorito") +
                        ", Fecha: " + rs.getDate("fecha_comienzo") +
                        ", URL: " + rs.getString("reference_url"));
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar: " + e.getMessage());
        }
    }
}
