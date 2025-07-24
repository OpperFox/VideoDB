package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/videodb";
        String user = "root";
        String password = "root1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ No se encontró el Driver JDBC.");
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión a la base de datos:");
            e.printStackTrace();
        }
        return null;
    }
    
}