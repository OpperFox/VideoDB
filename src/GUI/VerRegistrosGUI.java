package GUI;

// Importación de librerías necesarias para la interfaz gráfica
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

// Clase principal de la ventana para ver los registros
public class VerRegistrosGUI extends JFrame {

    // Componentes principales de la interfaz
    private JTextField campoBuscarNombre;
    private JComboBox<String> comboCalificacion, comboEstado;
    private JTable tablaRegistros;
    private DefaultTableModel modeloTabla;
    private MenuPrincipalGUI menuPrincipal; // Para regresar al menú

    // Constructor de la ventana, recibe como parámetro la ventana del menú principal y el nombre del usuario
    public VerRegistrosGUI(MenuPrincipalGUI menuPrincipal, String usuario) {
        this.menuPrincipal = menuPrincipal;

        // Título y configuración básica de la ventana
        setTitle("📂 Ver Registros de " + usuario);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(255, 102, 102)); // Fondo rojo pastel

        // Fuente que se usará en los componentes
        Font fuente = new Font("Comic Sans MS", Font.PLAIN, 15);

        // 🎯 PANEL SUPERIOR: Filtros de búsqueda
        JPanel panelFiltros = new JPanel(new FlowLayout()); // Usa distribución de flujo (horizontal)
        panelFiltros.setBackground(new Color(255, 102, 102)); // Mismo fondo

        campoBuscarNombre = new JTextField(12); // Campo para buscar por nombre
        campoBuscarNombre.setFont(fuente);

        // ComboBox para elegir calificación
        comboCalificacion = new JComboBox<>(new String[]{
            "Todas", "Horrible", "Malo", "Regular", "Bueno", "Sublime"
        });
        comboCalificacion.setFont(fuente);

        // ComboBox para filtrar por estado
        comboEstado = new JComboBox<>(new String[]{
            "Todos", "No visto", "En espera", "Revisto", "Viendo", "Completado", "Abandonado"
        });
        comboEstado.setFont(fuente);

        // Botón que aplica los filtros seleccionados
        JButton botonFiltrar = new JButton("🔍 Aplicar filtros");
        botonFiltrar.setFont(fuente);

        // Agrega los componentes al panel de filtros
        panelFiltros.add(new JLabel("🔠 Nombre:"));
        panelFiltros.add(campoBuscarNombre);
        panelFiltros.add(new JLabel("⭐ Calificación:"));
        panelFiltros.add(comboCalificacion);
        panelFiltros.add(new JLabel("📶 Estado:"));
        panelFiltros.add(comboEstado);
        panelFiltros.add(botonFiltrar);

        // Agrega el panel superior a la parte norte de la ventana
        add(panelFiltros, BorderLayout.NORTH);

        // 📋 PANEL CENTRAL: Tabla con registros
        String[] columnas = {"Nombre", "Categoría", "Estado", "Calificación", "Favorito", "Enlace"};
        modeloTabla = new DefaultTableModel(columnas, 0); // Modelo sin filas iniciales
        tablaRegistros = new JTable(modeloTabla); // Tabla con el modelo definido
        tablaRegistros.setFont(fuente);
        tablaRegistros.setRowHeight(22); // Altura de las filas

        // Agrega la tabla a un scroll y lo coloca en el centro
        JScrollPane scrollTabla = new JScrollPane(tablaRegistros);
        add(scrollTabla, BorderLayout.CENTER);

        // 🔙 PANEL INFERIOR: Botón para volver al menú
        JButton botonVolver = new JButton("🔙 Volver al menú");
        botonVolver.setFont(fuente);

        JPanel panelSur = new JPanel(); // Panel para contener el botón de volver
        panelSur.setBackground(new Color(255, 102, 102));
        panelSur.add(botonVolver);

        // Agrega el panel inferior al sur
        add(panelSur, BorderLayout.SOUTH);

        // Acción del botón de volver: cierra esta ventana y vuelve al menú principal
        botonVolver.addActionListener(e -> {
            dispose(); // Cierra esta ventana
            menuPrincipal.setVisible(true); // Muestra el menú
        });

        // Acción del botón de filtros: llama al método aplicarFiltros
        botonFiltrar.addActionListener((ActionEvent e) -> aplicarFiltros());

        // Configuración final de la ventana
        setSize(850, 450);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    // 🚧 Método que simula la búsqueda de registros según los filtros
    private void aplicarFiltros() {
        // Obtiene los filtros seleccionados por el usuario
        String nombre = campoBuscarNombre.getText().trim().toLowerCase();
        String calificacion = (String) comboCalificacion.getSelectedItem();
        String estado = (String) comboEstado.getSelectedItem();

        // Borra los registros actuales de la tabla
        modeloTabla.setRowCount(0);

        // ⚠️ Simulación de registros (deberían venir de una base de datos o lista real)
        String[][] registrosSimulados = {
            {"Inception", "Película", "Completado", "Sublime", "Sí", "https://inception.example.com"},
            {"Breaking Bad", "Serie", "Re visto", "Muy bueno", "No", "https://bb.example.com"},
            {"Mi Playlist Favorita", "Playlist", "En espera", "Regular", "Sí", "https://playlist.example.com"},
        };

        // Recorre los registros simulados y aplica los filtros
        for (String[] reg : registrosSimulados) {
            boolean coincide = true;

            // Filtra por nombre si se escribió algo
            if (!nombre.isEmpty() && !reg[0].toLowerCase().contains(nombre)) coincide = false;

            // Filtra por calificación si no es "Todas"
            if (!"Todas".equals(calificacion) && !reg[3].equals(calificacion)) coincide = false;

            // Filtra por estado si no es "Todos"
            if (!"Todos".equals(estado) && !reg[2].equals(estado)) coincide = false;

            // Si el registro cumple con todos los filtros, lo agrega a la tabla
            if (coincide) modeloTabla.addRow(reg);
        }
    }
}
