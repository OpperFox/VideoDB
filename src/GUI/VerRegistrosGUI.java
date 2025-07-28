package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class VerRegistrosGUI extends JFrame {
    private JTextField campoNombre;
    private JComboBox<String> comboCalificacion, comboEstado;
    private JButton botonAplicar, botonVolver;
    private JTable tablaRegistros;
    private DefaultTableModel modeloTabla;
    private ArrayList<String[]> registros; // Simulación de los registros

    public VerRegistrosGUI() {
        setTitle("📂 Ver Registros de admin");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Estilo: fondo pastel y fuente Comic Sans
        Color fondoRojoPastel = new Color(255, 153, 153);
        Color fondoCeleste = new Color(204, 229, 255);
        Font fuenteComic = new Font("Comic Sans MS", Font.PLAIN, 14);
        Font fuenteNegrita = new Font("Comic Sans MS", Font.BOLD, 14);

        // Panel de filtros
        JPanel panelFiltros = new JPanel();
        panelFiltros.setBackground(fondoRojoPastel);
        panelFiltros.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel etiquetaNombre = new JLabel("🖊️ Nombre:");
        etiquetaNombre.setFont(fuenteNegrita);
        campoNombre = new JTextField(10);
        campoNombre.setFont(fuenteComic);

        JLabel etiquetaCalificacion = new JLabel("★ Calificación:");
        etiquetaCalificacion.setFont(fuenteNegrita);
        comboCalificacion = new JComboBox<>(new String[]{"Todas", "Sublime", "Bueno", "Regular", "Malo", "Horrible"});
        comboCalificacion.setFont(fuenteComic);
        comboCalificacion.setBackground(fondoCeleste);

        JLabel etiquetaEstado = new JLabel("☑️ Estado:");
        etiquetaEstado.setFont(fuenteNegrita);
        comboEstado = new JComboBox<>(new String[]{"Todos", "Completado", "En proceso o viendo", "No visto", "Abandonado", "Re visto", "En espera"});
        comboEstado.setFont(fuenteComic);
        comboEstado.setBackground(fondoCeleste);

        botonAplicar = new JButton("🔎 Aplicar filtros");
        botonAplicar.setFont(fuenteComic);
        botonAplicar.setBackground(fondoCeleste);

        panelFiltros.add(etiquetaNombre);
        panelFiltros.add(campoNombre);
        panelFiltros.add(etiquetaCalificacion);
        panelFiltros.add(comboCalificacion);
        panelFiltros.add(etiquetaEstado);
        panelFiltros.add(comboEstado);
        panelFiltros.add(botonAplicar);

        // Tabla de registros
        String[] columnas = {"Nombre", "Categoría", "Estado", "Calificación", "Favorito", "Enlace"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaRegistros = new JTable(modeloTabla);
        tablaRegistros.setFont(fuenteComic);
        tablaRegistros.setRowHeight(24);
        tablaRegistros.getTableHeader().setFont(fuenteNegrita);
        JScrollPane scrollTabla = new JScrollPane(tablaRegistros);

        // Panel inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(fondoRojoPastel);
        botonVolver = new JButton("🔙 Volver al menú");
        botonVolver.setFont(fuenteComic);
        botonVolver.setBackground(fondoCeleste);
        panelInferior.add(botonVolver);

        // Layout principal
        setLayout(new BorderLayout());
        JScrollPane scrollFiltros = new JScrollPane(panelFiltros);
        scrollFiltros.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollFiltros.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        add(scrollFiltros, BorderLayout.NORTH);
        add(scrollTabla, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        
        registros = new ArrayList<>();
        try {
  
            
            List<String[]> resultados = SQL.Query.obtenerRegistrosUsuario(SQL.DBConnection.getConnection(), Main.currentUser);
            registros.addAll(resultados);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los registros desde la base de datos.");
        }

        // Eventos
        botonAplicar.addActionListener(e -> aplicarFiltros());
        botonVolver.addActionListener(e -> volverAlMenu());
        campoNombre.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                aplicarFiltros();
            }
        });
        comboCalificacion.addItemListener(e -> aplicarFiltros());
        comboEstado.addItemListener(e -> aplicarFiltros());

        aplicarFiltros(); // Mostrar todos
        setVisible(true);
    }

    private void aplicarFiltros() {
        String nombreFiltro = campoNombre.getText().toLowerCase();
        String calificacionFiltro = (String) comboCalificacion.getSelectedItem();
        String estadoFiltro = (String) comboEstado.getSelectedItem();

        // Imprimir los filtros seleccionados por consola
        System.out.println("- Nombre: " + (nombreFiltro.isEmpty() ? "(cualquiera)" : nombreFiltro));
        System.out.println("- Calificación: " + calificacionFiltro);
        System.out.println("- Estado: " + estadoFiltro);
        System.out.println("------------------------");

        modeloTabla.setRowCount(0); // Limpiar tabla

        for (String[] registro : registros) {
            boolean coincide = true;

            if (!nombreFiltro.isEmpty() && !registro[0].toLowerCase().contains(nombreFiltro)) {
                coincide = false;
            }

            if (!calificacionFiltro.equals("Todas") && !registro[3].equals(calificacionFiltro)) {
                coincide = false;
            }

            if (!estadoFiltro.equals("Todos") && !registro[2].equals(estadoFiltro)) {
                coincide = false;
            }

            if (coincide) {
                modeloTabla.addRow(registro);
            }
        }
    }

    private void volverAlMenu() {
        JOptionPane.showMessageDialog(this, "Volviendo al menú...");
        dispose();
        // Aquí puedes abrir MenuPrincipalGUI u otra clase si deseas
    }

    public static void main(String[] args) {
        new VerRegistrosGUI();
    }
}