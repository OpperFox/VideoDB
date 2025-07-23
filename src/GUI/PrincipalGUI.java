package GUI;

// Importamos las clases necesarias para crear interfaces gráficas en Java
import javax.swing.*;         // Contiene clases como JFrame, JButton, JLabel, etc.
import java.awt.*;            // Contiene clases para el diseño de ventanas (Layout, Color, etc.)
import java.awt.event.*;      // Contiene clases para manejar eventos como hacer clic en un botón

// Esta clase define la ventana principal del programa
public class PrincipalGUI extends JFrame {
	// Declaramos los botones que tendrá la ventana
	private JButton ingresar, registrarse, salir;

	// Constructor: aquí se arma todo el diseño de la ventana principal
	public PrincipalGUI() {
		// Título de la ventana
		setTitle("Bienvenido");

		// Cierra el programa al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Usamos BorderLayout para distribuir los elementos (arriba, centro, etc.)
		setLayout(new BorderLayout());

		// Cambiamos el color de fondo de toda la ventana a azul real
		getContentPane().setBackground(new Color(65, 105, 225)); 

		// Fuente que usaremos en los textos de la ventana (Comic Sans, negrita, tamaño 16)
		Font fuenteDivertida = new Font("Comic Sans MS", Font.BOLD, 16);

		// Creamos un mensaje en la parte superior
		JLabel mensaje = new JLabel("¡Bienvenido a Video DB!", JLabel.CENTER); // Centrado
		mensaje.setFont(fuenteDivertida);           // Aplicamos la fuente definida
		mensaje.setForeground(Color.BLACK);         // Color del texto
		mensaje.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); // Márgenes alrededor
		add(mensaje, BorderLayout.NORTH);           // Lo colocamos en la parte superior

		// Panel donde irán los botones principales (centro de la ventana)
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(3, 1, 10, 10)); // Tres botones en una columna
		panelBotones.setBackground(new Color(150, 0, 0));     // Fondo rojo
		panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100)); // Márgenes internos

		// Creamos los botones usando un método auxiliar para mantener el estilo
		ingresar = crearBoton("Ingresar", fuenteDivertida);
		registrarse = crearBoton("Registrarse", fuenteDivertida);
		salir = crearBoton("Salir del sistema", fuenteDivertida);

		// Acciones que ocurren cuando el usuario hace clic en cada botón:

		// Si presiona "Ingresar", abrimos la ventana de ingreso y ocultamos esta
		ingresar.addActionListener(e -> {
			new IngresarGUI(this);   // Abrimos la ventana de ingreso
			setVisible(false);       // Ocultamos la ventana principal
		});

		// Si presiona "Registrarse", abrimos la ventana de registro y ocultamos esta
		registrarse.addActionListener(e -> {
			new RegistrarseGUI(this);  // Abrimos la ventana de registro
			setVisible(false);         // Ocultamos la ventana principal
		});

		// Si presiona "Salir del sistema", cerramos el programa completamente
		salir.addActionListener(e -> System.exit(0));

		// Agregamos los botones al panel central
		panelBotones.add(ingresar);
		panelBotones.add(registrarse);
		panelBotones.add(salir);

		// Agregamos el panel de botones al centro de la ventana
		add(panelBotones, BorderLayout.CENTER);

		// Tamaño de la ventana (ancho, alto)
		setSize(400, 350);

		// Hace que la ventana aparezca en el centro de la pantalla
		setLocationRelativeTo(null);

		// Finalmente, hacemos visible la ventana
		setVisible(true);
	}

	// Método auxiliar para crear botones con un diseño consistente
	private JButton crearBoton(String texto, Font fuente) {
		JButton boton = new JButton(texto);   // Crea el botón con el texto dado
		boton.setFont(fuente);                // Aplica la fuente divertida
		boton.setBackground(Color.WHITE);     // Fondo blanco
		boton.setFocusPainted(false);         // Quita el borde de enfoque
		return boton;                         // Devuelve el botón creado
	}

	// Método principal del programa: inicia la aplicación
	public static void main(String[] args) {
	    // Ejecutamos la interfaz gráfica dentro del hilo especial de Swing
	    SwingUtilities.invokeLater(() -> new PrincipalGUI());
	}
}
