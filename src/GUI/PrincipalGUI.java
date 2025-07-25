package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrincipalGUI extends JFrame {
    private JButton ingresar, registrarse, salir;

    public PrincipalGUI() {
        setTitle("Bienvenido");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(65, 105, 225));

        Font fuenteDivertida = new Font("Comic Sans MS", Font.BOLD, 16);

        JLabel mensaje = new JLabel("¡Bienvenido a Video DB!", JLabel.CENTER);
        mensaje.setFont(fuenteDivertida);
        mensaje.setForeground(Color.BLACK);
        mensaje.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(mensaje, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10));
        panelBotones.setBackground(new Color(150, 0, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

        ingresar = crearBoton("Ingresar", fuenteDivertida);
        registrarse = crearBoton("Registrarse", fuenteDivertida);
        salir = crearBoton("Salir del sistema", fuenteDivertida);

        // Se llaman los métodos de acción
        ingresar.addActionListener(e -> abrirVentanaIngreso());
        registrarse.addActionListener(e -> abrirVentanaRegistro());
        salir.addActionListener(e -> cerrarAplicacion());

        panelBotones.add(ingresar);
        panelBotones.add(registrarse);
        panelBotones.add(salir);
        add(panelBotones, BorderLayout.CENTER);

        setSize(400, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ✅ Métodos públicos/privados para cada acción de los botones
    public void abrirVentanaIngreso() {
        new IngresarGUI(this);
        setVisible(false);
    }

    public void abrirVentanaRegistro() {
        new RegistrarseGUI(this);
        setVisible(false);
    }

    public void cerrarAplicacion() {
        System.exit(0);
    }

    // Método auxiliar para crear botones
    public JButton crearBoton(String texto, Font fuente) {
        JButton boton = new JButton(texto);
        boton.setFont(fuente);
        boton.setBackground(Color.WHITE);
        boton.setFocusPainted(false);
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PrincipalGUI());
    }
}
