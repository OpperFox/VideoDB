	package GUI;
	
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ItemEvent;
	
	// ... mismo paquete e importaciones que ya tenías
	import java.awt.event.*;

	public class AgregarRegistroGUI extends JFrame {

	    // Componentes principales
	    private JComboBox<String> comboCategoria;
	    private JTextField campoNombre, campoLink;
	    private JComboBox<String> comboEstado, comboCalificacion;
	    private JCheckBox checkFavorito;

	    private JComboBox<Integer> comboTemporada, comboCapitulo;
	    private JPanel panelTemporadaCapitulo;

	    public AgregarRegistroGUI(JFrame ventanaAnterior, String usuario) {
	        // Configuración básica
	        setTitle("Agregar nuevo registro");
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());
	        getContentPane().setBackground(new Color(255, 102, 102));

	        Font fuenteGeneral = new Font("Comic Sans MS", Font.PLAIN, 17);
	        Font fuenteTitulo = new Font("Comic Sans MS", Font.BOLD, 22);

	        JLabel etiquetaTitulo = new JLabel("Agregar nuevo registro");
	        etiquetaTitulo.setFont(fuenteTitulo);
	        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	        etiquetaTitulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
	        add(etiquetaTitulo, BorderLayout.NORTH);

	        JPanel panelCampos = new JPanel();
	        panelCampos.setLayout(new BoxLayout(panelCampos, BoxLayout.Y_AXIS));
	        panelCampos.setBackground(new Color(255, 102, 102));
	        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

	        comboCategoria = new JComboBox<>(new String[] {"Saga", "Playlist", "Serie"});
	        comboCategoria.setFont(fuenteGeneral);

	        campoNombre = new JTextField();
	        campoNombre.setFont(fuenteGeneral);

	        campoLink = new JTextField();
	        campoLink.setFont(fuenteGeneral);

	        comboEstado = new JComboBox<>(new String[] {
	            "No visto", "Re visto", "En proceso o viendo", "Completado", "Abandonado", "En espera"
	        });
	        comboEstado.setFont(fuenteGeneral);

	        comboCalificacion = new JComboBox<>(new String[] {
	            "Horrible", "Malo", "Regular", "Bueno", "Sublime"
	        });
	        comboCalificacion.setFont(fuenteGeneral);

	        checkFavorito = new JCheckBox("Marcar como favorito");
	        checkFavorito.setFont(fuenteGeneral);
	        checkFavorito.setBackground(new Color(255, 102, 102));

	        // ------ LISTENERS AÑADIDOS ------

	        campoNombre.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyReleased(KeyEvent e) {
	                System.out.println("Texto en nombre: " + campoNombre.getText());
	            }
	        });

	        campoLink.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyReleased(KeyEvent e) {
	                System.out.println("Texto en enlace: " + campoLink.getText());
	            }
	        });

	        comboEstado.addItemListener(e -> {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                System.out.println("Estado seleccionado: " + comboEstado.getSelectedItem());
	            }
	        });

	        comboCalificacion.addItemListener(e -> {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                System.out.println("Calificación seleccionada: " + comboCalificacion.getSelectedItem());
	            }
	        });

	        checkFavorito.addActionListener(e -> {
	            boolean favorito = checkFavorito.isSelected();
	            System.out.println("¿Favorito? " + (favorito ? "Sí" : "No"));
	        });

	        // ------ CONTINÚA EL CÓDIGO NORMAL ------

	        panelTemporadaCapitulo = new JPanel(new GridLayout(2, 2, 10, 10));
	        panelTemporadaCapitulo.setBackground(new Color(255, 102, 102));
	        panelTemporadaCapitulo.setVisible(false);

	        comboTemporada = new JComboBox<>();
	        comboCapitulo = new JComboBox<>();
	        for (int i = 1; i <= 50; i++) comboTemporada.addItem(i);
	        for (int i = 1; i <= 100; i++) comboCapitulo.addItem(i);
	        comboTemporada.setFont(fuenteGeneral);
	        comboCapitulo.setFont(fuenteGeneral);

	        panelTemporadaCapitulo.add(new JLabel("Temporada:"));
	        panelTemporadaCapitulo.add(comboTemporada);
	        panelTemporadaCapitulo.add(new JLabel("Capítulo:"));
	        panelTemporadaCapitulo.add(comboCapitulo);

	        comboCategoria.addItemListener(e -> {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                String seleccion = (String) e.getItem();
	                panelTemporadaCapitulo.setVisible("Serie".equals(seleccion));
	                pack();
	            }
	        });

	        panelCampos.add(crearFila("Categoría:", comboCategoria));
	        panelCampos.add(crearFila("Nombre:", campoNombre));
	        panelCampos.add(panelTemporadaCapitulo);
	        panelCampos.add(crearFila("Estado:", comboEstado));
	        panelCampos.add(crearFila("Enlace o link:", campoLink));
	        panelCampos.add(crearFila("Calificación:", comboCalificacion));
	        panelCampos.add(checkFavorito);

	        add(panelCampos, BorderLayout.CENTER);

	        JPanel panelBotones = new JPanel(new FlowLayout());
	        panelBotones.setBackground(new Color(255, 102, 102));

	        JButton botonGuardar = new JButton("Guardar");
	        JButton botonGuardarVolver = new JButton("Guardar y volver al menú");
	        JButton botonCancelar = new JButton("Volver al menú sin guardar");

	        botonGuardar.setFont(fuenteGeneral);
	        botonGuardarVolver.setFont(fuenteGeneral);
	        botonCancelar.setFont(fuenteGeneral);

	        panelBotones.add(botonGuardar);
	        panelBotones.add(botonGuardarVolver);
	        panelBotones.add(botonCancelar);

	        add(panelBotones, BorderLayout.SOUTH);

	        botonGuardar.addActionListener(e -> {
	            JOptionPane.showMessageDialog(this, "Registro guardado.");
	        });

	        botonGuardarVolver.addActionListener(e -> {
	            JOptionPane.showMessageDialog(this, "Registro guardado.");
	            dispose();
	            ventanaAnterior.setVisible(true);
	        });

	        botonCancelar.addActionListener(e -> {
	            dispose();
	            ventanaAnterior.setVisible(true);
	        });

	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

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
