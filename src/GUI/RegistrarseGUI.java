package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrarseGUI extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoClave;
    private JButton botonRegistrar, botonVolver;
    private PrincipalGUI ventanaPrincipal; // Guardamos la referencia

    public RegistrarseGUI(PrincipalGUI ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Registro de Usuario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(65, 105, 225));
        Font fuente = new Font("Comic Sans MS", Font.BOLD, 18);

        JLabel titulo = new JLabel("Crear nuevo usuario", JLabel.CENTER);
        titulo.setFont(fuente);
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titulo, BorderLayout.NORTH);

        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCampos.setBackground(new Color(150, 0, 0));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60));

        JLabel lblUsuario = new JLabel("Usuario:", JLabel.RIGHT);
        lblUsuario.setFont(fuente);
        panelCampos.add(lblUsuario);

        campoUsuario = new JTextField();
        panelCampos.add(campoUsuario);

        JLabel lblClave = new JLabel("Clave:", JLabel.RIGHT);
        lblClave.setFont(fuente);
        panelCampos.add(lblClave);

        campoClave = new JPasswordField();
        panelCampos.add(campoClave);

        add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(new Color(150, 0, 0));

        botonRegistrar = new JButton("Registrar");
        botonRegistrar.setFont(fuente);
        botonRegistrar.addActionListener(e -> registrarUsuario());

        botonVolver = new JButton("Volver");
        botonVolver.setFont(fuente);
        botonVolver.addActionListener(e -> volverAPrincipal());

<<<<<<< HEAD
=======
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
                if (!usuario.isEmpty() && !clave.isEmpty() && ! SQL.Query.user_exists(SQL.DBConnection.getConnection(),usuario,clave))  {
                    // Muestra mensaje de éxito
                	
                	//Logica.User x = new Logica.User(usuario, clave);
                	SQL.Query.user_registry(SQL.DBConnection.getConnection(), usuario, clave);
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
>>>>>>> 7464460f052d067c9ea6605a8f7aa62f07884d04
        panelBotones.add(botonRegistrar);
        panelBotones.add(botonVolver);

        add(panelBotones, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ---------- NUEVOS MÉTODOS PÚBLICOS ----------

    public void registrarUsuario() {
        String usuario = campoUsuario.getText();
        String clave = new String(campoClave.getPassword());

        if (!usuario.isEmpty() && !clave.isEmpty()) {
            // Lógica real de registro vendría aquí (verificación en base de datos)
            JOptionPane.showMessageDialog(this, "Usuario creado con éxito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            volverAPrincipal();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor completa todos los campos", "Error de registro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void volverAPrincipal() {
        ventanaPrincipal.setVisible(true);
        dispose();
    }
}
