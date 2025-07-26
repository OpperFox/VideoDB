package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/videodb";

    private static final String USER1 = "root";
    private static final String PASS1 = "root1234";

    private static final String USER2 = "root";
    private static final String PASS2 = "zNmats1C*YrP%s&0";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Solo necesitas cargar el driver una vez
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontró el Driver JDBC.");
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER1, PASS1);
        } catch (SQLException e) {
            System.err.println("Error de conexión con user1:");
            e.printStackTrace();
            try {
                return DriverManager.getConnection(URL, USER2, PASS2);
            } catch (SQLException ee) {
                System.err.println("Error de conexión con user2:");
                e.printStackTrace();
                return null;
            }
        }
    }
}
