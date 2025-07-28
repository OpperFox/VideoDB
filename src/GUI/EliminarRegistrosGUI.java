package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class EliminarRegistrosGUI extends JFrame {

    private JTable tablaRegistros;
    private DefaultTableModel modeloTabla;
    private MenuPrincipalGUI menuPrincipal;
    private int usuario_id; // ✅ Variable para almacenar el ID del usuario

    public EliminarRegistrosGUI(MenuPrincipalGUI menuPrincipal, String usuario) {
        this.menuPrincipal = menuPrincipal;

        // 🔽 Obtener el ID del usuario desde la base de datos
        this.usuario_id = SQL.Query.mostrar_id_usuario(SQL.DBConnection.getConnection(), usuario);

        if (usuario_id == -1) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        setTitle("Eliminar Registros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 102, 102));

        Font fuente = new Font("Comic Sans MS", Font.PLAIN, 15);

        String[] columnas = {"Seleccionar", "Nombre", "Categoría", "Calificación", "Favorito", "Enlace"};

        modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };

        tablaRegistros = new JTable(modeloTabla);
        tablaRegistros.setFont(fuente);
        tablaRegistros.setRowHeight(24);
        JScrollPane scrollTabla = new JScrollPane(tablaRegistros);
        add(scrollTabla, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(255, 102, 102));

        JButton botonEliminar = new JButton("Eliminar seleccionados");
        botonEliminar.setFont(fuente);
        botonEliminar.addActionListener((ActionEvent e) -> eliminarSeleccionados());

        JButton botonVolver = new JButton("Volver al menú");
        botonVolver.setFont(fuente);
        botonVolver.addActionListener(e -> {
            dispose();
            menuPrincipal.setVisible(true);
        });

        panelBotones.add(botonEliminar);
        panelBotones.add(botonVolver);
        add(panelBotones, BorderLayout.SOUTH);

        cargarDatosDesdeSQL();

        setSize(900, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cargarDatosDesdeSQL() {
        modeloTabla.setRowCount(0);
        List<String[]> registros = SQL.Query.obtenerRegistrosUsuario(SQL.DBConnection.getConnection(), usuario_id);

        for (String[] fila : registros) {
            modeloTabla.addRow(new Object[]{
                    false,
                    fila[0],  // Nombre
                    fila[1],  // Tipo
                    fila[2],  // Calificación
                    fila[3],  // Favorito
                    fila[4]   // URL
            });
        }
    }

    private void eliminarSeleccionados() {
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas eliminar los registros seleccionados?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {

            // Recorre la tabla de abajo hacia arriba para evitar errores al eliminar filas
            for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
                Boolean seleccionado = (Boolean) modeloTabla.getValueAt(i, 0);
                if (seleccionado != null && seleccionado) {
                    String nombre = modeloTabla.getValueAt(i, 1).toString();
                    String tipo = modeloTabla.getValueAt(i, 2).toString();

                    boolean eliminado = SQL.Query.usermediaregistry_delete(SQL.DBConnection.getConnection(), nombre, tipo, usuario_id);

                    if (eliminado) {
                        modeloTabla.removeRow(i); // Elimina de la tabla visual también
                    } else {
                        JOptionPane.showMessageDialog(this,
                            "No se pudo eliminar: " + nombre + " (" + tipo + ")",
                            "Error al eliminar",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            JOptionPane.showMessageDialog(this, "Registros eliminados correctamente.");
        	}  




            // Recorre la tabla desde el final hacia el inicio
            for (int i = modeloTabla.getRowCount() - 1; i >= 0; i--) {
                Boolean seleccionado = (Boolean) modeloTabla.getValueAt(i, 0);
                if (seleccionado != null && seleccionado) {

                    // Imprimir toda la fila en consola
                    StringBuilder filaTexto = new StringBuilder("Registro seleccionado:\n");
                    for (int j = 1; j < modeloTabla.getColumnCount(); j++) {
                        String nombreColumna = modeloTabla.getColumnName(j);
                        Object valorCelda = modeloTabla.getValueAt(i, j);
                        filaTexto.append(nombreColumna).append(": ").append(valorCelda).append("\n");
                    }
                    System.out.println(filaTexto);

                    // Elimina la fila seleccionada
                    modeloTabla.removeRow(i);
                }
            }

            // Mensaje de confirmación
            JOptionPane.showMessageDialog(this, "Registros eliminados correctamente.");
        }
    }

