package GUI; // El paquete donde se encuentra esta clase

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
        new PrincipalGUI();
    }
}
