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
