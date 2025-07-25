package GUI;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class VerRegistrosGUI extends JFrame {
    private JTextField campoBuscarNombre;
    private JTextField campoBuscarEnlace;
    private JComboBox<String> comboEstado;
    private JComboBox<String> comboCalificacion;
    private JComboBox<String> comboCategoria;
    private JCheckBox checkFavorito;

    private JPanel panelRegistros;

    public VerRegistrosGUI() {
        setTitle("Registros Existentes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFiltros = new JPanel(new GridLayout(3, 2));

        campoBuscarNombre = new JTextField();
        campoBuscarEnlace = new JTextField();

        comboEstado = new JComboBox<>(new String[]{"", "Visto", "Pendiente"});
        comboCalificacion = new JComboBox<>(new String[]{"", "1", "2", "3", "4", "5"});
        comboCategoria = new JComboBox<>(new String[]{"", "Series", "Playlist" , "Saga"});

        checkFavorito = new JCheckBox("Solo favoritos");

        panelFiltros.add(new JLabel("Buscar por nombre:"));
        panelFiltros.add(campoBuscarNombre);
        panelFiltros.add(new JLabel("Buscar por enlace:"));
        panelFiltros.add(campoBuscarEnlace);
        panelFiltros.add(new JLabel("Estado:"));
        panelFiltros.add(comboEstado);
        panelFiltros.add(new JLabel("Calificación:"));
        panelFiltros.add(comboCalificacion);
        panelFiltros.add(new JLabel("Categoría:"));
        panelFiltros.add(comboCategoria);
        panelFiltros.add(new JLabel("Favorito:"));
        panelFiltros.add(checkFavorito);

        add(panelFiltros, BorderLayout.NORTH);

        panelRegistros = new JPanel();
        add(new JScrollPane(panelRegistros), BorderLayout.CENTER);

        // Listeners de texto
        campoBuscarNombre.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { aplicarFiltros(); }
            public void removeUpdate(DocumentEvent e) { aplicarFiltros(); }
            public void changedUpdate(DocumentEvent e) { aplicarFiltros(); }
        });

        campoBuscarEnlace.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { aplicarFiltros(); }
            public void removeUpdate(DocumentEvent e) { aplicarFiltros(); }
            public void changedUpdate(DocumentEvent e) { aplicarFiltros(); }
        });

        // Listeners de selección
        comboEstado.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    aplicarFiltros();
                }
            }
        });

        comboCalificacion.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    aplicarFiltros();
                }
            }
        });

        comboCategoria.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    aplicarFiltros();
                }
            }
        });

        checkFavorito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aplicarFiltros();
            }
        });

        setVisible(true);
    }

    // Método central que debe aplicar todos los filtros combinados
    private void aplicarFiltros() {
        String nombre = campoBuscarNombre.getText().trim().toLowerCase();
        String enlace = campoBuscarEnlace.getText().trim().toLowerCase();
        String estado = (String) comboEstado.getSelectedItem();
        String calificacion = (String) comboCalificacion.getSelectedItem();
        String categoria = (String) comboCategoria.getSelectedItem();
        boolean esFavorito = checkFavorito.isSelected();

        // Aquí deberías usar estos valores para filtrar tus registros (pendiente de implementar)
        System.out.println("Filtro aplicado:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Enlace: " + enlace);
        System.out.println("Estado: " + estado);
        System.out.println("Calificación: " + calificacion);
        System.out.println("Categoría: " + categoria);
        System.out.println("¿Favorito?: " + esFavorito);

        // Aquí iría la lógica para actualizar el panelRegistros con los resultados filtrados
    }
}
