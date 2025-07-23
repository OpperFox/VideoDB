package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Esta clase representa la ventana gráfica para eliminar registros del sistema.
 * Muestra una tabla con registros y permite seleccionar cuáles se desean eliminar.
 */
public class EliminarRegistrosGUI extends JFrame {

    private JTable tablaRegistros;                 // Tabla visual que contiene los registros
    private DefaultTableModel modeloTabla;         // Modelo de datos para la tabla
    private MenuPrincipalGUI menuPrincipal;        // Referencia a la ventana principal

    /**
     * Constructor de la ventana EliminarRegistrosGUI
     * @param menuPrincipal ventana principal a la que se regresará al salir
     * @param usuario nombre del usuario (no se usa directamente aquí, pero puede ser útil)
     */
    public EliminarRegistrosGUI(MenuPrincipalGUI menuPrincipal, String usuario) {
        this.menuPrincipal = menuPrincipal;

        setTitle("Eliminar Registros"); // Título de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Al cerrar esta ventana, se termina el programa
        setLayout(new BorderLayout()); // Usa un diseño con zonas (NORTE, CENTRO, SUR, etc.)
        getContentPane().setBackground(new Color(255, 102, 102)); // Fondo rojo pastel

        Font fuente = new Font("Comic Sans MS", Font.PLAIN, 15); // Fuente personalizada

        // Encabezados de la tabla
        String[] columnas = {"Seleccionar", "Nombre", "Categoría", "Estado", "Calificación", "Favorito", "Enlace"};

        // Modelo personalizado para permitir checkbox solo en la primera columna
        modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : String.class; // Columna 0 es un checkbox
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0; // Solo la columna de selección es editable
            }
        };

        // Crea la tabla con el modelo anterior
        tablaRegistros = new JTable(modeloTabla);
        tablaRegistros.setFont(fuente);
        tablaRegistros.setRowHeight(24); // Altura de cada fila
        JScrollPane scrollTabla = new JScrollPane(tablaRegistros); // Permite scroll si hay muchos datos
        add(scrollTabla, BorderLayout.CENTER); // Agrega la tabla al centro de la ventana

        // Panel inferior con botones
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(255, 102, 102)); // Mismo fondo pastel

        // Botón para eliminar registros seleccionados
        JButton botonEliminar = new JButton("Eliminar seleccionados");
        botonEliminar.setFont(fuente);
        botonEliminar.addActionListener((ActionEvent e) -> eliminarSeleccionados());

        // Botón para volver al menú principal
        JButton botonVolver = new JButton("Volver al menú");
        botonVolver.setFont(fuente);
        botonVolver.addActionListener(e -> {
            dispose(); // Cierra esta ventana
            menuPrincipal.setVisible(true); // Muestra la ventana principal nuevamente
        });

        // Agrega los botones al panel y el panel a la ventana
        panelBotones.add(botonEliminar);
        panelBotones.add(botonVolver);
        add(panelBotones, BorderLayout.SOUTH);

        // Cargar registros ficticios simulados (para prueba visual)
        cargarDatosSimulados();

        setSize(900, 450); // Tamaño inicial de la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setVisible(true); // Muestra la ventana
    }

    /**
     * Método que carga datos ficticios para visualizar cómo se verían los registros
     */
    private void cargarDatosSimulados() {
        Object[][] datos = {
            {false, "Inception", "Película", "Completado", "Sublime", "Sí", "https://inception.example.com"},
            {false, "Breaking Bad", "Serie", "Re visto", "Muy bueno", "No", "https://bb.example.com"},
            {false, "Mi Playlist", "Música", "En espera", "Regular", "Sí", "https://playlist.example.com"}
        };

        // Agrega cada fila al modelo de la tabla
        for (Object[] fila : datos) {
            modeloTabla.addRow(fila);
        }
    }

    /**
     * Método que elimina todos los registros que fueron seleccionados con el checkbox
     */
    private void eliminarSeleccionados() {
        // Muestra una confirmación antes de eliminar
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas eliminar los registros seleccionados?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        // Si el usuario confirmó
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Recorre la tabla desde el final hacia el inicio (para evitar errores al eliminar filas)
            for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
                Boolean seleccionado = (Boolean) modeloTabla.getValueAt(i, 0);
                if (seleccionado != null && seleccionado) {
                    modeloTabla.removeRow(i); // Elimina la fila seleccionada
                }
            }

            // Muestra un mensaje de éxito
            JOptionPane.showMessageDialog(this, "Registros eliminados correctamente.");
        }
    }
}
