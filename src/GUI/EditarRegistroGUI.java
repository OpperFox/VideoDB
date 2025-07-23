package GUI;

// Se importan las clases necesarias para crear interfaces gráficas con Swing y manejar eventos
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
    private String usuario;

    // Constructor que recibe la ventana anterior y el nombre del usuario
    public EditarRegistroGUI(JFrame ventanaAnterior, String usuario) {
        this.ventanaAnterior = ventanaAnterior;
        this.usuario = usuario;

        // Configuración básica de la ventana
        setTitle("Editar registro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 102, 102)); // fondo rojo pastel

        // Fuentes personalizadas para el diseño divertido
        Font fuenteGeneral = new Font("Comic Sans MS", Font.PLAIN, 16);
        Font fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 22);

        // Título de la ventana
        JLabel etiquetaTitulo = new JLabel("✏️ Editar registros existentes");
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

        // Se agregan registros de ejemplo (puedes cambiarlos por registros reales)
        modeloLista = new DefaultListModel<>();
        modeloLista.addElement("Película: Inception");
        modeloLista.addElement("Serie: Dark");
        modeloLista.addElement("Playlist: Mi Top 10 2025");

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

        // Combo con estados posibles (preestablecidos)
        comboEstado = new JComboBox<>(new String[]{
            "No visto", "Re visto", "En proceso o viendo", "Completado", "Abandonado", "En espera"
        });

        // Combo con calificaciones posibles (preestablecidas)
        comboCalificacion = new JComboBox<>(new String[]{
            "Horrible", "Malo", "Regular", "Bueno", "Muy bueno", "Sublime"
        });

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
        JButton botonGuardar = new JButton("💾 Guardar");
        JButton botonGuardarVolver = new JButton("💾 Guardar y volver al menú");
        JButton botonCancelar = new JButton("🔙 Volver al menú sin guardar");
        JButton botonEliminar = new JButton("🗑️ Eliminar registro");

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
        botonGuardar.addActionListener((ActionEvent e) -> {
            if (validarEntrada()) {
                JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
            }
        });

        // Acción al presionar "Guardar y volver"
        botonGuardarVolver.addActionListener((ActionEvent e) -> {
            if (validarEntrada()) {
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
                    modeloLista.remove(index);
                    JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.");
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
