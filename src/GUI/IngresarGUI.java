package GUI;

// Importamos las librerías necesarias para crear interfaces gráficas con Swing
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IngresarGUI extends JFrame {
    // Campos de texto para que el usuario escriba su nombre de usuario y clave
    private JTextField campoUsuario;
    private JPasswordField campoClave;
    // Botones para ingresar al sistema y para volver a la ventana anterior
    private JButton botonIngresar, botonVolver;
    private  String usuario;
    private String clave;
    

    // Constructor que recibe como parámetro la ventana principal para poder volver a ella
    public IngresarGUI(PrincipalGUI ventanaPrincipal) {
        setTitle("Iniciar Sesión 🌟"); // Título de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLayout(new BorderLayout()); // Usamos un layout para organizar los elementos
        getContentPane().setBackground(new Color(65, 105, 225)); // Establece el fondo azul

        // Definimos la fuente divertida y legible
        Font fuente = new Font("Comic Sans MS", Font.BOLD, 18);

        // Creamos un título en la parte superior de la ventana
        JLabel titulo = new JLabel("Ingrese sus datos", JLabel.CENTER);
        titulo.setFont(fuente);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); // Espacios alrededor del texto
        add(titulo, BorderLayout.NORTH); // Lo ubicamos arriba

        // Creamos un panel para los campos de usuario y clave
        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 filas y 2 columnas
        panelCampos.setBackground(new Color(150,0,0)); // Fondo rojo
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60)); // Espacios internos

        // Etiqueta y campo para el nombre de usuario
        JLabel lblUsuario = new JLabel("Usuario:", JLabel.RIGHT);
        lblUsuario.setFont(fuente);
        campoUsuario = new JTextField(); // Campo de texto simple

        // Etiqueta y campo para la clave
        JLabel lblClave = new JLabel("Clave:", JLabel.RIGHT);
        lblClave.setFont(fuente);
        campoClave = new JPasswordField(); // Campo de contraseña que oculta lo que se escribe

        // Añadimos las etiquetas y campos al panel
        panelCampos.add(lblUsuario);
        panelCampos.add(campoUsuario);
        panelCampos.add(lblClave);
        panelCampos.add(campoClave);

        // Añadimos el panel de campos al centro de la ventana
        add(panelCampos, BorderLayout.CENTER);

        // Creamos un panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout()); // Coloca los botones en fila
        panelBotones.setBackground(new Color(150,0,0)); // Mismo fondo rojo

        // Creamos el botón para ingresar
        botonIngresar = new JButton("Ingresar");
        botonIngresar.setFont(fuente);

        // Creamos el botón para volver a la ventana principal
        botonVolver = new JButton("🔙 Volver");
        botonVolver.setFont(fuente);

        // Acción del botón "Volver": muestra la ventana principal y cierra esta
        botonVolver.addActionListener(e -> {
            ventanaPrincipal.setVisible(true); // Vuelve a mostrar la ventana principal
            dispose(); // Cierra esta ventana
        });

        // Acción del botón "Ingresar"
        botonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Tomamos el texto escrito por el usuario
                usuario = campoUsuario.getText();
                 clave = new String(campoClave.getPassword()); // Convertimos la clave a texto

                // Validación simple de usuario y contraseña
                if ((usuario == "admin" && clave == "admin") || (SQL.Query.user_exists(SQL.DBConnection.getConnection(),usuario,clave))) {
                    // Si es correcto, muestra un mensaje de bienvenida
                	
                	Main.currentUser = Long.valueOf(usuario);
                	
                    JOptionPane.showMessageDialog(
                        IngresarGUI.this,
                        "Inicio de sesión exitoso",
                        "Bienvenido",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    new MenuPrincipalGUI(usuario); // Crea la siguiente ventana y le pasa el nombre del usuario
                    dispose(); // Cierra la ventana de inicio de sesión
                } else {
                    // Si los datos están mal, muestra un mensaje de error
                    JOptionPane.showMessageDialog(
                        IngresarGUI.this,
                        "Datos incorrectos. Inténtelo de nuevo.",
                        "Error de autenticación",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Añadimos los botones al panel
        panelBotones.add(botonIngresar);
        panelBotones.add(botonVolver);

        // Añadimos el panel de botones en la parte inferior
        add(panelBotones, BorderLayout.SOUTH);

        // Tamaño de la ventana
        setSize(400, 300);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true); // Muestra la ventana
    }
}
