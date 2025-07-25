package GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class VerRegistrosGUI extends JFrame {

    private JTextField campoBuscarNombre;
    private JComboBox<String> comboCalificacion, comboEstado, comboCategoria, comboFavorito;
    private JTable tablaRegistros;
    private DefaultTableModel modeloTabla;
    private MenuPrincipalGUI menuPrincipal;

    public VerRegistrosGUI(MenuPrincipalGUI menuPrincipal, String usuario) {
        this.menuPrincipal = menuPrincipal;

        setTitle("Ver Registros de " + usuario);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 102, 102));

        Font fuente = new Font("Comic Sans MS", Font.PLAIN, 15);

        // PANEL DE FILTROS
        JPanel panelFiltros = new JPanel(new FlowLayout());
        panelFiltros.setBackground(new Color(255, 102, 102));

        campoBuscarNombre = new JTextField(10);
        campoBuscarNombre.setFont(fuente);

        comboCalificacion = new JComboBox<>(new String[]{
                "Todas", "Horrible", "Malo", "Regular", "Bueno", "Sublime"
        });
        comboCalificacion.setFont(fuente);

        comboEstado = new JComboBox<>(new String[]{
                "Todos", "No visto", "En espera", "Revisto", "Viendo", "Completado", "Abandonado"
        });
        comboEstado.setFont(fuente);

        comboCategoria = new JComboBox<>(new String[]{
                "Todas", "Película", "Serie", "Anime", "Música", "Playlist"
        });
        comboCategoria.setFont(fuente);

        comboFavorito = new JComboBox<>(new String[]{
                "Todos", "Sí", "No"
        });
        comboFavorito.setFont(fuente);

        JButton botonFiltrar = new JButton("Aplicar filtros");
        botonFiltrar.setFont(fuente);

        panelFiltros.add(new JLabel("Nombre:"));
        panelFiltros.add(campoBuscarNombre);
        panelFiltros.add(new JLabel("Categoría:"));
        panelFiltros.add(comboCategoria);
        panelFiltros.add(new JLabel("Estado:"));
        panelFiltros.add(comboEstado);
        panelFiltros.add(new JLabel("Calificación:"));
        panelFiltros.add(comboCalificacion);
        panelFiltros.add(new JLabel("Favorito:"));
        panelFiltros.add(comboFavorito);
        panelFiltros.add(botonFiltrar);

        add(panelFiltros, BorderLayout.NORTH);

        // TABLA DE REGISTROS
        String[] columnas = {"Nombre", "Categoría", "Estado", "Calificación", "Favorito", "Enlace"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaRegistros = new JTable(modeloTabla);
        tablaRegistros.setFont(fuente);
        tablaRegistros.setRowHeight(22);

        JScrollPane scrollTabla = new JScrollPane(tablaRegistros);
        add(scrollTabla, BorderLayout.CENTER);

        // PANEL INFERIOR
        JButton botonVolver = new JButton("Volver al menú");
        botonVolver.setFont(fuente);
        JPanel panelSur = new JPanel();
        panelSur.setBackground(new Color(255, 102, 102));
        panelSur.add(botonVolver);
        add(panelSur, BorderLayout.SOUTH);

        // ACCIONES DE BOTONES
        botonVolver.addActionListener(e -> {
            dispose();
            menuPrincipal.setVisible(true);
        });

        botonFiltrar.addActionListener(e -> aplicarFiltros());

        // LISTENERS AUTOMÁTICOS

        campoBuscarNombre.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { aplicarFiltros(); }
            public void removeUpdate(DocumentEvent e) { aplicarFiltros(); }
            public void changedUpdate(DocumentEvent e) { aplicarFiltros(); }
        });

        comboCalificacion.addActionListener(e -> aplicarFiltros());
        comboEstado.addActionListener(e -> aplicarFiltros());
        comboCategoria.addActionListener(e -> aplicarFiltros());
        comboFavorito.addActionListener(e -> aplicarFiltros());

        // CONFIG FINAL
        setSize(950, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // APLICA FILTROS COMBINADOS
    private void aplicarFiltros() {
        String nombre = campoBuscarNombre.getText().trim().toLowerCase();
        String calificacion = (String) comboCalificacion.getSelectedItem();
        String estado = (String) comboEstado.getSelectedItem();
        String categoria = (String) comboCategoria.getSelectedItem();
        String favorito = (String) comboFavorito.getSelectedItem();

        modeloTabla.setRowCount(0);

        // Datos simulados
        /*String[][] registrosSimulados = {
                {"Inception", "Película", "Completado", "Sublime", "Sí", "https://inception.example.com"},
                {"Breaking Bad", "Serie", "Revisto", "Bueno", "No", "https://bb.example.com"},
                {"Mi Playlist Favorita", "Playlist", "En espera", "Regular", "Sí", "https://playlist.example.com"},
                {"Naruto", "Anime", "Completado", "Bueno", "No", "https://naruto.example.com"},
                {"Interstellar", "Película", "No visto", "Sublime", "Sí", "https://interstellar.example.com"},
        };

        for (String[] reg : registrosSimulados) {
            boolean coincide = true;

            if (!nombre.isEmpty() && !reg[0].toLowerCase().contains(nombre)) coincide = false;
            if (!"Todas".equals(calificacion) && !reg[3].equalsIgnoreCase(calificacion)) coincide = false;
            if (!"Todos".equals(estado) && !reg[2].equalsIgnoreCase(estado)) coincide = false;
            if (!"Todas".equals(categoria) && !reg[1].equalsIgnoreCase(categoria)) coincide = false;
            if (!"Todos".equals(favorito) && !reg[4].equalsIgnoreCase(favorito)) coincide = false;

            if (coincide) modeloTabla.addRow(reg);
        }*/
    }
}
