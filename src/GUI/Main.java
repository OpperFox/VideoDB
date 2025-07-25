package GUI; // El paquete donde se encuentra esta clase.

import java.sql.*;
import java.time.LocalDate;

import SQL.*;

/**
 * Clase principal que inicia la aplicación.
 * 
 * Esta clase contiene el método `main`, que es el punto de entrada de cualquier programa Java.
 * Desde aquí se lanza la interfaz gráfica principal del sistema de registros multimedia.
 */
public class Main {
	
	static public int 
	currentUser, 
	currentMediaRegistry,
	currentMediaContent,
	currentVideo,
	currentVideoInfo;

	static Date fecha;
	
	static public LocalDate localDate;
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
    	
    	//public 
    	
        new PrincipalGUI();
        
        Connection conn = DBConnection.getConnection();
        LocalDate localDate = LocalDate.now(); 
        fecha = Date.valueOf(localDate);
        
        SQL.Query.user_exists(conn, "name", "name");
        
        SQL.Query.usermediaregistry_exists(
        	    conn,
        	    "Dark",
        	    "SUBLIME",
        	    "VIENDO",
        	    "Serie",
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