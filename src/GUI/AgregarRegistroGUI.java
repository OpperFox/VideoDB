package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

/**
 * Clase que representa la ventana de interfaz gráfica para agregar un nuevo registro
 * al sistema (películas, playlists, series).
 * 
 * Esta clase extiende JFrame, lo que permite crear una ventana con campos de entrada,
 * botones y componentes visuales para capturar los datos del usuario.
 */
public class AgregarRegistroGUI extends JFrame {

    // Componentes principales
    private JComboBox<String> comboCategoria; // Desplegable para elegir la categoría del registro
    private JTextField campoNombre, campoLink; // Campos de texto para nombre y enlace
    private JComboBox<String> comboEstado, comboCalificacion; // Listas desplegables para estado y calificación
    private JCheckBox checkFavorito; // Casilla para marcar como favorito

    // Campos adicionales para series (temporadas y capítulos)
    private JComboBox<Integer> comboTemporada, comboCapitulo; 
    private JPanel panelTemporadaCapitulo; // Panel que contiene los combos de temporada y capítulo

    /**
     * Constructor que crea la interfaz gráfica para agregar registros.
     * 
     * @param ventanaAnterior La ventana desde la cual se llamó esta (para volver luego).
     * @param usuario El nombre del usuario que está usando el sistema (no usado aún pero podría usarse para personalizar).
     */
    public AgregarRegistroGUI(JFrame ventanaAnterior, String usuario) {
        // Configuración básica de la ventana
        setTitle("Agregar nuevo registro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 102, 102)); // Fondo rojo pastel

        // Fuentes utilizadas
        Font fuenteGeneral = new Font("Comic Sans MS", Font.PLAIN, 17);
        Font fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 22);

        // Título superior
        JLabel etiquetaTitulo = new JLabel("📄 Agregar nuevo registro");
        etiquetaTitulo.setFont(fuenteTitulo);
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(etiquetaTitulo, BorderLayout.NORTH);

        // Panel central para campos de entrada
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));
        panelCampos.setBackground(new Color(255, 102, 102));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        // Combo para seleccionar la categoría del registro
        comboCategoria = new JComboBox<>(new String[] {"Película", "Playlist", "Series"});
        comboCategoria.setFont(fuenteGeneral);

        // Campos comunes para todas las categorías
        campoNombre = new JTextField();
        campoNombre.setFont(fuenteGeneral);

        campoLink = new JTextField();
        campoLink.setFont(fuenteGeneral);

        // Estado del registro
        comboEstado = new JComboBox<>(new String[] {
            "No visto", "Re visto", "En proceso o viendo", "Completado", "Abandonado", "En espera"
        });
        comboEstado.setFont(fuenteGeneral);

        // Calificación del registro
        comboCalificacion = new JComboBox<>(new String[] {
            "Horrible", "Malo", "Regular", "Bueno", "Sublime"
        });
        comboCalificacion.setFont(fuenteGeneral);

        // Checkbox para marcar como favorito
        checkFavorito = new JCheckBox("Marcar como favorito");
        checkFavorito.setFont(fuenteGeneral);
        checkFavorito.setBackground(new Color(255, 102, 102));

        // Panel para campos específicos de series (temporada y capítulo)
        panelTemporadaCapitulo = new JPanel(new GridLayout(2, 2, 10, 10));
        panelTemporadaCapitulo.setBackground(new Color(255, 102, 102));
        panelTemporadaCapitulo.setVisible(false); // Inicialmente oculto

        // Combos para seleccionar temporada y capítulo
        comboTemporada = new JComboBox<>();
        comboCapitulo = new JComboBox<>();
        for (int i = 1; i <= 50; i++) comboTemporada.addItem(i);
        for (int i = 1; i <= 100; i++) comboCapitulo.addItem(i);
        comboTemporada.setFont(fuenteGeneral);
        comboCapitulo.setFont(fuenteGeneral);

        // Agregar etiquetas y combos al panel de temporada/capítulo
        panelTemporadaCapitulo.add(new JLabel("Temporada:"));
        panelTemporadaCapitulo.add(comboTemporada);
        panelTemporadaCapitulo.add(new JLabel("Capítulo:"));
        panelTemporadaCapitulo.add(comboCapitulo);

        // Evento que se activa cuando cambia la categoría seleccionada
        comboCategoria.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String seleccion = (String) e.getItem();
                // Mostrar o esconder campos adicionales si es Series
                panelTemporadaCapitulo.setVisible("Series".equals(seleccion));
                pack(); // Redimensionar ventana automáticamente
            }
        });

        // Agregar todos los campos al panel principal
        panelCampos.add(crearFila("Categoría:", comboCategoria));
        panelCampos.add(crearFila("Nombre:", campoNombre));
        panelCampos.add(panelTemporadaCapitulo); // Solo visible si se elige "Series"
        panelCampos.add(crearFila("Estado:", comboEstado));
        panelCampos.add(crearFila("Enlace o link:", campoLink));
        panelCampos.add(crearFila("Calificación:", comboCalificacion));
        panelCampos.add(checkFavorito);

        add(panelCampos, BorderLayout.CENTER); // Agregar panel al centro

        // Panel con botones inferiores
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(new Color(255, 102, 102));

        JButton botonGuardar = new JButton("💾 Guardar");
        JButton botonGuardarVolver = new JButton("💾 Guardar y volver al menú");
        JButton botonCancelar = new JButton("🔙 Volver al menú sin guardar");

        botonGuardar.setFont(fuenteGeneral);
        botonGuardarVolver.setFont(fuenteGeneral);
        botonCancelar.setFont(fuenteGeneral);

        panelBotones.add(botonGuardar);
        panelBotones.add(botonGuardarVolver);
        panelBotones.add(botonCancelar);

        add(panelBotones, BorderLayout.SOUTH); // Agregar panel de botones abajo

        // Acciones para los botones
        botonGuardar.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Registro guardado.");
            // Aquí puedes agregar la lógica para guardar el registro realmente
        });

        botonGuardarVolver.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Registro guardado.");
            dispose(); // Cierra esta ventana
            ventanaAnterior.setVisible(true); // Muestra la anterior
        });

        botonCancelar.addActionListener((ActionEvent e) -> {
            dispose(); // Cierra sin guardar
            ventanaAnterior.setVisible(true);
        });

        // Finalizar configuración de la ventana
        pack(); // Ajustar tamaño automáticamente
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true); // Mostrar la ventana
    }

    /**
     * Método auxiliar para crear una fila con una etiqueta y un componente (campo de entrada).
     * 
     * @param etiqueta Texto de la etiqueta
     * @param componente Campo o combo que se mostrará al lado derecho
     * @return Panel con la fila construida
     */
    private JPanel crearFila(String etiqueta, JComponent componente) {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.setBackground(new Color(255, 102, 102));
        JLabel label = new JLabel(etiqueta);
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        panel.add(label);
        panel.add(componente);
        return panel;
    }
}
