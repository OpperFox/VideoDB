package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Clase que representa el menú principal de la aplicación.
 * Muestra botones para navegar entre las diferentes funciones del sistema.
 */
public class MenuPrincipalGUI extends JFrame {

    private JButton botonAgregar, botonEditar, botonVer, botonEliminar;
    private String usuario; // Nombre del usuario autenticado

    public MenuPrincipalGUI(String usuario) {
        this.usuario = usuario;

        setTitle("Menú Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 102, 102));

        Font fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 22);
        Font fuenteBoton = new Font("Comic Sans MS", Font.PLAIN, 16);

        JLabel etiquetaBienvenida = new JLabel("Bienvenido " + usuario);
        etiquetaBienvenida.setFont(fuenteTitulo);
        etiquetaBienvenida.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
        add(etiquetaBienvenida, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 15, 15));
        panelBotones.setBackground(new Color(255, 102, 102));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Botones
        botonAgregar = new JButton("Agregar nuevo registro");
        botonEditar = new JButton("Editar registros");
        botonVer = new JButton("Registros existentes");
        botonEliminar = new JButton("Eliminar o borrar registro");

        botonAgregar.setFont(fuenteBoton);
        botonEditar.setFont(fuenteBoton);
        botonVer.setFont(fuenteBoton);
        botonEliminar.setFont(fuenteBoton);

        // Listeners que llaman métodos separados
        botonAgregar.addActionListener(e -> abrirVentanaAgregar());
        botonEditar.addActionListener(e -> abrirVentanaEditar());
        botonVer.addActionListener(e -> abrirVentanaVer());
        botonEliminar.addActionListener(e -> abrirVentanaEliminar());

        panelBotones.add(botonAgregar);
        panelBotones.add(botonEditar);
        panelBotones.add(botonVer);
        panelBotones.add(botonEliminar);
        add(panelBotones, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(255, 102, 102));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton botonCerrarSesion = new JButton("Cerrar sesión");
        botonCerrarSesion.setFont(fuenteBoton);
        botonCerrarSesion.addActionListener((ActionEvent e) -> cerrarSesion());

        panelInferior.add(botonCerrarSesion);
        add(panelInferior, BorderLayout.SOUTH);

        setSize(500, 350);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // MÉTODOS INDIVIDUALES PARA CADA BOTÓN (pueden ser llamados desde otras clases)
    public void abrirVentanaAgregar() {
        new AgregarRegistroGUI(this, usuario);
        setVisible(false);
    }

    public void abrirVentanaEditar() {
        new EditarRegistroGUI(this, usuario);
        setVisible(false);
    }

    public void abrirVentanaVer() {
        new VerRegistrosGUI(this, usuario);
        setVisible(false);
    }

    public void abrirVentanaEliminar() {
        new EliminarRegistrosGUI(this, usuario);
        setVisible(false);
    }

    public void cerrarSesion() {
        dispose();
        new PrincipalGUI();
    }
}
