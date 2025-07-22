package GUI; // Paquete donde se encuentra esta clase

// Importación de las librerías necesarias para crear la interfaz gráfica
import javax.swing.*;  // Componentes de Swing como JFrame, JButton, JTextField, etc.
import java.awt.*;     // Para colores, fuentes, diseño de layouts
import java.awt.event.*; // Para manejar eventos como clicks en botones

// Clase que representa la ventana de registro de usuario, extiende JFrame (ventana)
public class RegistrarseGUI extends JFrame {

    // Declaración de los componentes que estarán en la interfaz
    private JTextField campoUsuario;          // Campo para escribir el nombre de usuario
    private JPasswordField campoClave;        // Campo para escribir la clave (oculta)
    private JButton botonRegistrar, botonVolver; // Botones para registrar y volver

    // Constructor de la clase que recibe como parámetro la ventana principal
    public RegistrarseGUI(PrincipalGUI ventanaPrincipal) {

        // Configura el título de la ventana
        setTitle("Registro de Usuario");

        // Define qué pasa cuando se cierra la ventana (salir del programa)
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Usa un diseño de BorderLayout (divide la ventana en norte, sur, centro, este, oeste)
        setLayout(new BorderLayout());

        // Cambia el color de fondo de la ventana a un azul
        getContentPane().setBackground(new Color(65, 105, 225));

        // Define una fuente personalizada para los textos
        Font fuente = new Font("Comic Sans MS", Font.BOLD, 18);

        // ---------- TÍTULO ----------

        // Crea una etiqueta con el texto centrado
        JLabel titulo = new JLabel("Crear nuevo usuario", JLabel.CENTER);
        titulo.setFont(fuente); // Aplica la fuente
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); // Márgenes alrededor
        add(titulo, BorderLayout.NORTH); // Añade la etiqueta en la parte superior

        // ---------- CAMPOS DE TEXTO ----------

        // Panel con diseño de cuadrícula para organizar las etiquetas y campos
        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 filas, 2 columnas, espacio de 10px
        panelCampos.setBackground(new Color(150, 0, 0)); // Fondo rojo oscuro
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60)); // Márgenes internos

        // Etiqueta para "Usuario" alineada a la derecha
        panelCampos.add(new JLabel("Usuario:", JLabel.RIGHT)).setFont(fuente); // (¡OJO!: esto no aplica la fuente directamente)
        campoUsuario = new JTextField(); // Campo de texto para el usuario
        panelCampos.add(campoUsuario);   // Se añade al panel

        // Etiqueta para "Clave" alineada a la derecha
        panelCampos.add(new JLabel("Clave:", JLabel.RIGHT)).setFont(fuente); // (¡OJO!: esto no aplica la fuente directamente)
        campoClave = new JPasswordField(); // Campo de contraseña (oculta caracteres)
        panelCampos.add(campoClave);       // Se añade al panel

        add(panelCampos, BorderLayout.CENTER); // Se añade el panel al centro de la ventana

        // ---------- BOTONES ----------

        // Panel para los botones con diseño de flujo (alineados horizontalmente)
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(new Color(150, 0, 0)); // Mismo fondo rojo oscuro

        // Botón para registrar el usuario
        botonRegistrar = new JButton("Registrar");
        botonRegistrar.setFont(fuente); // Se le aplica la fuente

        // Botón para volver a la ventana principal
        botonVolver = new JButton("🔙 Volver");
        botonVolver.setFont(fuente);

        // Evento que se ejecuta al hacer clic en "Volver"
        botonVolver.addActionListener(e -> {
            ventanaPrincipal.setVisible(true); // Vuelve a mostrar la ventana principal
            dispose();                         // Cierra la ventana actual
        });

        // Evento que se ejecuta al hacer clic en "Registrar"
        botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se obtiene el texto ingresado por el usuario
                String usuario = campoUsuario.getText();
                String clave = new String(campoClave.getPassword()); // Se convierte el arreglo de caracteres en String

                // Se valida que ambos campos no estén vacíos
                if (!usuario.isEmpty() && !clave.isEmpty()) {
                    // Muestra mensaje de éxito
                    JOptionPane.showMessageDialog(
                        RegistrarseGUI.this,
                        "Usuario creado con éxito",
                        "Registro exitoso",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    ventanaPrincipal.setVisible(true); // Muestra la ventana principal
                    dispose();                         // Cierra la ventana de registro
                } else {
                    // Si algún campo está vacío, se muestra un mensaje de error
                    JOptionPane.showMessageDialog(
                        RegistrarseGUI.this,
                        "Por favor completa todos los campos",
                        "Error de registro",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // Añade los botones al panel
        panelBotones.add(botonRegistrar);
        panelBotones.add(botonVolver);

        // Añade el panel de botones a la parte inferior de la ventana
        add(panelBotones, BorderLayout.SOUTH);

        // Ajusta el tamaño de la ventana
        setSize(400, 300);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Hace visible la ventana
        setVisible(true);
    }
}
