package GUI; // El paquete donde se encuentra esta clase.

import java.sql.*;

/**
 * Clase principal que inicia la aplicación.
 * 
 * Esta clase contiene el método `main`, que es el punto de entrada de cualquier programa Java.
 * Desde aquí se lanza la interfaz gráfica principal del sistema de registros multimedia.
 */
public class Main {

    /**
     * Método main: punto de entrada del programa.
     * 
     * Al ejecutar el programa, este método crea una nueva instancia de la clase PrincipalGUI,
     * que abre la ventana principal donde el usuario puede elegir entre ingresar o registrarse.
     *
     * @param args Argumentos que pueden ser pasados por la línea de comandos (no se usan en este caso).
     */
    public static void main(String[] args) {
        // Se lanza la ventana principal de la aplicación (pantalla de inicio)
    	
    	Long currentUser;
    	Long currentMediaRegistry;
    	Long currentMediaContent;
    	Long currentVideo;
    	Long currentVideoInfo;
    	
    	//public 
    	
        new PrincipalGUI();
        
        Connection conn = SQL.DBConnection.getConnection();
        Date fecha = Date.valueOf("2022-05-15");
        
        SQL.Query.user_exists(conn, "name", "name");
        
        SQL.Query.usermediaregistry_exists(
        	    conn,
        	    "Dark",
        	    "SUBLIME",
        	    "VIENDO",
        	    true,
        	    fecha,
        	    "https://www.netflix.com/title/80100172",
        	    1
        	);
        
        SQL.Query.mediacontent_exists(
        	    conn,
        	    1, 
        	    101,  
        	    "Universo alternativo",     // alfa
        	    "Origen de los viajes en el tiempo", // beta
        	    "Dark - Temporada 1",       // nombre
        	    "TEMPORADA"                 // tipo
        	);
        
        SQL.Query.video_exists(conn, 1, 203, "Dark - Final Revelation");
        SQL.Query.VideoUrl_exists(conn, 1, 203, "https://www.youtube.com/watch?v=example_dark_final");
        
        SQL.Query.uservideoinfo_exists(conn, true, "SUBLIME", "COMPLETADO", 1, 203, 1);

        SQL.Query.uservideohistory_exists(conn, fecha, 1);
        
    }
}