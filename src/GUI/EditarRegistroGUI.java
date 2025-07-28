package GUI;

// Se importan las clases necesarias para crear interfaces gráficas con Swing y manejar eventos.
import javax.swing.*;

import LOGICA.Rating;
import LOGICA.Status;
import SQL.DBConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

// Clase que representa la ventana para editar registros guardados por el usuario
public class EditarRegistroGUI extends JFrame {
    // Campos de texto para editar el nombre y el enlace
    private JTextField campoNombre, campoLink;

    // Checkbox para marcar si es favorito
    private JCheckBox checkFavorito;

    // Combos desplegables para elegir el estado y la calificación
    private JComboBox<String> comboEstado, comboCalificacion;

    // Lista que muestra los registros actuales
    private JList<String> listaRegistros;

    // Modelo de la lista, permite modificar su contenido dinámicamente
    private DefaultListModel<String> modeloLista;

    // Referencia a la ventana anterior (por ejemplo, el menú principal)
    private JFrame ventanaAnterior;

    // Nombre de usuario actual (se puede usar para cargar registros personalizados)
    //******************************************************************************************************************************
    
    private String usuario;
    private int usuario_id;
    
    
    
//--------------------------------------------------------------------------------------------------------------------------------
    // Constructor que recibe la ventana anterior y el nombre del usuario
    public EditarRegistroGUI(JFrame ventanaAnterior, String usuario) {
        this.ventanaAnterior = ventanaAnterior;
        this.usuario = usuario;
        this.usuario_id = SQL.Query.mostrar_id_usuario(SQL.DBConnection.getConnection(), usuario);
        
        if (usuario_id == -1) {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        // Configuración básica de la ventana
        setTitle("Editar registro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 102, 102)); // fondo rojo pastel

        // Fuentes personalizadas para el diseño divertido
        Font fuenteGeneral = new Font("Comic Sans MS", Font.PLAIN, 16);
        Font fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 22);

        // Título de la ventana
        JLabel etiquetaTitulo = new JLabel("Editar registros existentes");
        etiquetaTitulo.setFont(fuenteTitulo);
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(etiquetaTitulo, BorderLayout.NORTH);

        // Panel izquierdo: muestra la lista de registros disponibles
        JPanel panelLista = new JPanel(new BorderLayout());
        panelLista.setBackground(new Color(255, 102, 102));
        panelLista.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        JLabel etiquetaSeleccion = new JLabel("Seleccione un registro para editar:");
        etiquetaSeleccion.setFont(fuenteGeneral);

        // 
//**********************************************************************************************************************************
        modeloLista = new DefaultListModel<>();
        List<String> nombreytipo = SQL.Query.obtenerNombreTipo_media(SQL.DBConnection.getConnection(), usuario_id);

        for (String tipo : nombreytipo) {
            modeloLista.addElement(tipo + " ");
        }

        // Lista gráfica con scroll
        listaRegistros = new JList<>(modeloLista);
        listaRegistros.setFont(fuenteGeneral);
        JScrollPane scrollLista = new JScrollPane(listaRegistros);

        // Se añaden componentes al panel izquierdo
        panelLista.add(etiquetaSeleccion, BorderLayout.NORTH);
        panelLista.add(scrollLista, BorderLayout.CENTER);
        add(panelLista, BorderLayout.WEST);

        // Panel central con los campos de edición
        JPanel panelEdicion = new JPanel(new GridLayout(6, 2, 10, 10));
        panelEdicion.setBackground(new Color(255, 102, 102));
        panelEdicion.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        // Campos editables
        campoNombre = new JTextField();
        campoLink = new JTextField();

        // Combo con estados posibles (preestablecidos) //**************************************************************************
        comboEstado = new JComboBox(Status.values());
        comboEstado.setFont(fuenteGeneral);

        comboCalificacion = new JComboBox(Rating.values());
        comboCalificacion.setFont(fuenteGeneral);

        // Check para marcar como favorito
        checkFavorito = new JCheckBox("Marcar como favorito");
        checkFavorito.setBackground(new Color(255, 102, 102));
        checkFavorito.setFont(fuenteGeneral);

        // Se agregan los campos al panel de edición
        panelEdicion.add(crearEtiqueta("Nuevo nombre:", fuenteGeneral));
        panelEdicion.add(campoNombre);

        panelEdicion.add(crearEtiqueta("Nuevo estado:", fuenteGeneral));
        panelEdicion.add(comboEstado);

        panelEdicion.add(crearEtiqueta("Nuevo enlace o link:", fuenteGeneral));
        panelEdicion.add(campoLink);

        panelEdicion.add(crearEtiqueta("Nueva calificación:", fuenteGeneral));
        panelEdicion.add(comboCalificacion);

        panelEdicion.add(new JLabel()); // Espacio vacío
        panelEdicion.add(checkFavorito);

        add(panelEdicion, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(new Color(255, 102, 102));

        // Botones de acción
        JButton botonGuardar = new JButton("Guardar");
        JButton botonGuardarVolver = new JButton("Guardar y volver al menú");
        JButton botonCancelar = new JButton("Volver al menú sin guardar");
        JButton botonEliminar = new JButton("Eliminar registro");

        // Estilo a los botones
        botonGuardar.setFont(fuenteGeneral);
        botonGuardarVolver.setFont(fuenteGeneral);
        botonCancelar.setFont(fuenteGeneral);
        botonEliminar.setFont(fuenteGeneral);

        // Se añaden botones al panel
        panelBotones.add(botonGuardar);
        panelBotones.add(botonGuardarVolver);
        panelBotones.add(botonCancelar);
        panelBotones.add(botonEliminar);

        add(panelBotones, BorderLayout.SOUTH);

        // Acción al presionar "Guardar" 
        //***************************************************************************************************************************
        botonGuardar.addActionListener((ActionEvent e) -> {
            if (validarEntrada()) {
<<<<<<< HEAD

=======
>>>>>>> 438faddb4bae945b3bc79960618e1f2bcf9f5012
                // Mostrar datos en consola
                System.out.println("Registro seleccionado: " + listaRegistros.getSelectedValue());
                System.out.println("Nuevo nombre: " + campoNombre.getText());
                System.out.println("Nuevo enlace: " + campoLink.getText());
                System.out.println("Nuevo estado: " + comboEstado.getSelectedItem().toString());
                System.out.println("Nueva calificación: " + comboCalificacion.getSelectedItem().toString());
                System.out.println("¿Favorito? " + (checkFavorito.isSelected() ? "Sí" : "No"));

                JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
<<<<<<< HEAD

=======
>>>>>>> 438faddb4bae945b3bc79960618e1f2bcf9f5012
                // Nuevos valores del formulario
                String nuevoNombre = campoNombre.getText();
                String rating = comboCalificacion.getSelectedItem().toString();
                String status = comboEstado.getSelectedItem().toString();
                boolean favorito = checkFavorito.isSelected();
                String referenceUrl = campoLink.getText();

                // Obtener el registro seleccionado
                String seleccionado = listaRegistros.getSelectedValue(); // Ej: "Tipo: SERIE | Nombre: BREAKING BAD"
                
                if (seleccionado != null && seleccionado.contains("|")) {
                    // Extraer tipo y nombre original
                    String[] partes = seleccionado.split("\\|");
                    String tipo = partes[0].split(":")[1].trim();
                    String nombreAnterior = partes[1].split(":")[1].trim();

                    // Llamar al método SQL con nombreAnterior y tipo
                    SQL.Query.usermediaregistry_edit(
                        SQL.DBConnection.getConnection(),
                        usuario,
                        tipo,
                        nombreAnterior,
                        nuevoNombre,
                        rating,
                        status,
                        favorito,
                        referenceUrl
                    );

                    JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al interpretar el registro seleccionado.");
                }
<<<<<<< HEAD

=======
>>>>>>> 438faddb4bae945b3bc79960618e1f2bcf9f5012
            }
        });

        // Acción al presionar "Guardar y volver"
        //**************************************************************************************************************************
        botonGuardarVolver.addActionListener((ActionEvent e) -> {
            if (validarEntrada()) {
<<<<<<< HEAD

=======
>>>>>>> 438faddb4bae945b3bc79960618e1f2bcf9f5012
                // Mostrar datos en consola
                System.out.println("Registro seleccionado: " + listaRegistros.getSelectedValue());
                System.out.println("Nuevo nombre: " + campoNombre.getText());
                System.out.println("Nuevo enlace: " + campoLink.getText());
                System.out.println("Nuevo estado: " + comboEstado.getSelectedItem().toString());
                System.out.println("Nueva calificación: " + comboCalificacion.getSelectedItem().toString());
                System.out.println("¿Favorito? " + (checkFavorito.isSelected() ? "Sí" : "No"));

<<<<<<< HEAD

=======
>>>>>>> 438faddb4bae945b3bc79960618e1f2bcf9f5012
            	if (validarEntrada()) {
                    // Nuevos valores del formulario
                    String nuevoNombre = campoNombre.getText();
                    String rating = comboCalificacion.getSelectedItem().toString();
                    String status = comboEstado.getSelectedItem().toString();
                    boolean favorito = checkFavorito.isSelected();
                    String referenceUrl = campoLink.getText();

                    // Obtener el registro seleccionado
                    String seleccionado = listaRegistros.getSelectedValue(); // Ej: "Tipo: SERIE | Nombre: BREAKING BAD"
                    
                    if (seleccionado != null && seleccionado.contains("|")) {
                        // Extraer tipo y nombre original
                        String[] partes = seleccionado.split("\\|");
                        String tipo = partes[0].split(":")[1].trim();
                        String nombreAnterior = partes[1].split(":")[1].trim();

                        // Llamar al método SQL con nombreAnterior y tipo
                        SQL.Query.usermediaregistry_edit(
                            SQL.DBConnection.getConnection(),
                            usuario,
                            tipo,
                            nombreAnterior,
                            nuevoNombre,
                            rating,
                            status,
                            favorito,
                            referenceUrl
                        );

                        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al interpretar el registro seleccionado.");
                    }
                }
            	            	
<<<<<<< HEAD

=======
>>>>>>> 438faddb4bae945b3bc79960618e1f2bcf9f5012
                JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
                volverAlMenu();
            }
        });

        // Volver al menú sin guardar
        botonCancelar.addActionListener(e -> volverAlMenu());

        // Acción al presionar "Eliminar"
        botonEliminar.addActionListener(e -> {
            int index = listaRegistros.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Por favor selecciona un registro para eliminar.");
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
<<<<<<< HEAD
                	
=======
>>>>>>> 438faddb4bae945b3bc79960618e1f2bcf9f5012
                    // Mostrar dato eliminado en consola
                    String eliminado = modeloLista.getElementAt(index);
                    System.out.println("Registro eliminado: " + eliminado);

                    modeloLista.remove(index);
                    JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.");
                    
                    String entrada = nombreytipo.get(index); // Ej: "Tipo: SERIE | Nombre: BREAKING BAD"
                    if (entrada != null && entrada.contains("|")) {
                        String[] partes = entrada.split("\\|");
                        String tipo = partes[0].split(":")[1].trim();
                        String nombre = partes[1].split(":")[1].trim();

                        // Llamada al método que elimina en SQL
                        boolean eliminado1 = SQL.Query.usermediaregistry_delete(SQL.DBConnection.getConnection(), nombre, tipo, usuario_id);

                        if (eliminado1) {
                            modeloLista.remove(index); 
                            nombreytipo.remove(index); 
                            JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(this, "No se pudo eliminar el registro de la base de datos.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Formato de registro inválido.");
                    }
                }
            }
        });



        // Tamaño y ubicación de la ventana
        setSize(850, 450);
        setLocationRelativeTo(null); // Centrada
        setVisible(true);
    }

    // Método auxiliar para crear etiquetas con estilo
    private JLabel crearEtiqueta(String texto, Font fuente) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(fuente);
        return etiqueta;
    }

    // Método que valida si los campos tienen información válida antes de guardar
    private boolean validarEntrada() {
        if (listaRegistros.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona un registro para editar.");
            return false;
        }
        if (campoNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
            return false;
        }
        return true;
    }

    // Método para volver al menú anterior
    private void volverAlMenu() {
        dispose(); // Cierra esta ventana
        ventanaAnterior.setVisible(true); // Muestra la anterior
    }
}
