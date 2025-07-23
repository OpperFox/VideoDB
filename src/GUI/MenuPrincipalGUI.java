package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Clase que representa el menú principal de la aplicación,
 * al que se accede luego de iniciar sesión correctamente.
 * Muestra botones para navegar entre las diferentes funciones del sistema.
 */
public class MenuPrincipalGUI extends JFrame {

    private JButton botonAgregar, botonEditar, botonVer, botonEliminar;
    private String usuario; // Guarda el nombre del usuario que inició sesión

    /**
     * Constructor del menú principal.
     * @param usuario Nombre del usuario que se ha autenticado.
     */
    public MenuPrincipalGUI(String usuario) {
        this.usuario = usuario;

        setTitle("Menú Principal"); // Título de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        setLayout(new BorderLayout()); // Se usa BorderLayout para organizar los paneles
        getContentPane().setBackground(new Color(255, 102, 102)); // Color de fondo rojo pastel

        // Fuentes personalizadas
        Font fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 22); // Fuente para el título
        Font fuenteBoton = new Font("Comic Sans MS", Font.PLAIN, 16); // Fuente para los botones

        // Etiqueta de bienvenida en la parte superior
        JLabel etiquetaBienvenida = new JLabel("Bienvenido " + usuario);
        etiquetaBienvenida.setFont(fuenteTitulo);
        etiquetaBienvenida.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
        add(etiquetaBienvenida, BorderLayout.NORTH); // Se coloca en la parte superior

        // Panel central que contiene los botones principales
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 15, 15)); // 2x2 botones con espacio entre ellos
        panelBotones.setBackground(new Color(255, 102, 102)); // Mismo fondo que la ventana
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40)); // Margen interno

        // Crear botones para las acciones
        botonAgregar = new JButton("Agregar nuevo registro");
        botonEditar = new JButton("Editar registros");
        botonVer = new JButton("Registros existentes");
        botonEliminar = new JButton("Eliminar o borrar registro");

        // Aplicar fuente a los botones
        botonAgregar.setFont(fuenteBoton);
        botonEditar.setFont(fuenteBoton);
        botonVer.setFont(fuenteBoton);
        botonEliminar.setFont(fuenteBoton);

        // Acciones para cada botón:
        // Cada uno abre una nueva ventana correspondiente y oculta el menú principal

        botonAgregar.addActionListener(e -> {
            new AgregarRegistroGUI(this, usuario); // Abre ventana para agregar registro
            setVisible(false); // Oculta esta ventana
        });

        botonEditar.addActionListener(e -> {
            new EditarRegistroGUI(this, usuario); // Abre ventana para editar
            setVisible(false);
        });

        botonVer.addActionListener(e -> {
            new VerRegistrosGUI(this, usuario); // Abre ventana para ver registros.
            setVisible(false);
        });

        botonEliminar.addActionListener(e -> {
            new EliminarRegistrosGUI(this, usuario); // Abre ventana para eliminar registros
            setVisible(false);
        });

        // Agregar los botones al panel
        panelBotones.add(botonAgregar);
        panelBotones.add(botonEditar);
        panelBotones.add(botonVer);
        panelBotones.add(botonEliminar);

        // Agregar panel central al centro del BorderLayout
        add(panelBotones, BorderLayout.CENTER);

        // Panel inferior con botón para cerrar sesión
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(255, 102, 102));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Botón para cerrar sesión
        JButton botonCerrarSesion = new JButton("Cerrar sesión");
        botonCerrarSesion.setFont(fuenteBoton);
        panelInferior.add(botonCerrarSesion); // Añade botón al panel inferior
        add(panelInferior, BorderLayout.SOUTH); // Lo ubica abajo

        // Acción del botón de cerrar sesión
        botonCerrarSesion.addActionListener((ActionEvent e) -> {
            dispose(); // Cierra esta ventana
            new PrincipalGUI(); // Vuelve a la ventana principal de inicio de sesión o registro
        });

        // Configuración final de la ventana
        setSize(500, 350); // Tamaño de la ventana
        setLocationRelativeTo(null); // Centrar en la pantalla
        setVisible(true); // Mostrar la ventana
    }
}
