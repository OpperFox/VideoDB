package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import LOGICA.*;
import SQL.*;

public class AgregarRegistroGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Componentes principales
    private JComboBox<ContentType> comboCategoria;
    private JTextField campoNombre, campoLink;
    private JComboBox<String> comboEstado, comboCalificacion;
    private JCheckBox checkFavorito;

    private JComboBox<Integer> comboTemporada, comboCapitulo;
    private JPanel panelTemporadaCapitulo;
    
    private String
    nombre,
    url;
    
    private Rating rating;
    private Status status;
    private ContentType categoria;
    
    private boolean favorito;

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

        comboCategoria = new JComboBox<ContentType>(new ContentType[] {ContentType.SAGA, ContentType.SERIE, ContentType.PLAYLIST}	);
        comboCategoria.setFont(fuenteGeneral);

        campoNombre = new JTextField();
        campoNombre.setFont(fuenteGeneral);

        campoLink = new JTextField();
        campoLink.setFont(fuenteGeneral);

        comboEstado = new JComboBox(Status.values());
        comboEstado.setFont(fuenteGeneral);

        comboCalificacion = new JComboBox(Rating.values());
        comboCalificacion.setFont(fuenteGeneral);

        checkFavorito = new JCheckBox("Marcar como favorito");
        checkFavorito.setFont(fuenteGeneral);
        checkFavorito.setBackground(new Color(255, 102, 102));

        // ------ LISTENERS AÑADIDOS ------

        campoNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Texto en nombre: " + campoNombre.getText());
                nombre = campoNombre.getText();
            }
        });

        campoLink.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Texto en enlace: " + campoLink.getText());
                
                url = campoLink.getText();
                
            }
        });

        comboEstado.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("Estado seleccionado: " + comboEstado.getSelectedItem().toString());
                
                status = (Status) comboEstado.getSelectedItem();
                
            }
        });

        comboCalificacion.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("Calificación seleccionada: " + comboCalificacion.getSelectedItem().toString());
                
                rating = (Rating) comboCalificacion.getSelectedItem();
                
            }
        });

        checkFavorito.addActionListener(e -> {
            boolean favorito = checkFavorito.isSelected();
            System.out.println("¿Favorito? " + (favorito ? "Sí" : "No"));
            
            favorito = checkFavorito.isSelected();
            
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
            	categoria = (ContentType) comboCategoria.getSelectedItem();
                System.out.println("Categoria Seleccionada: " + categoria.toString());
                panelTemporadaCapitulo.setVisible("Serie".equals(categoria.toString()));
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
        	
        	status = (Status) comboEstado.getSelectedItem();
        	categoria = (ContentType) comboCategoria.getSelectedItem();
        	rating = (Rating) comboCalificacion.getSelectedItem();
        	
        	System.out.println("-----------------");
        	System.out.println("Datos Guardados: ");
        	
        	System.out.println("Estado Seleccionada: " + status.toString());
        	System.out.println("Texto en nombre: " + campoNombre.getText());
        	System.out.println("Categoria Seleccionada: " + categoria.toString());
        	System.out.println("Texto en enlace: " + campoLink.getText());
        	System.out.println("Calificación seleccionada: " + comboCalificacion.getSelectedItem().toString());
        	System.out.println("¿Favorito? " + (favorito ? "Sí" : "No"));
        	
        	Query.usermediaregistry_registry(DBConnection.getConnection(),nombre, rating.toString(), status.toString(), categoria.toString(), favorito, Main.fecha, url, Main.currentUser);
            JOptionPane.showMessageDialog(this, "Registro guardado.");
            
                       
        });

        botonGuardarVolver.addActionListener(e -> {
        	
        	status = (Status) comboEstado.getSelectedItem();
        	categoria = (ContentType) comboCategoria.getSelectedItem();
        	rating = (Rating) comboCalificacion.getSelectedItem();
        	favorito = checkFavorito.isSelected();
        	
        	System.out.println("-----------------");
        	System.out.println("Datos Guardados: ");
        	
        	System.out.println("Estado Seleccionada: " + status.toString());
        	System.out.println("Texto en nombre: " + campoNombre.getText());
        	System.out.println("Categoria Seleccionada: " + categoria.toString());
        	System.out.println("Texto en enlace: " + campoLink.getText());
        	System.out.println("Calificación seleccionada: " + comboCalificacion.getSelectedItem().toString());
        	System.out.println("¿Favorito? " + (favorito ? "Sí" : "No"));
        	
        	Query.usermediaregistry_registry(DBConnection.getConnection(),nombre, rating.toString(), status.toString(), categoria.toString(), favorito, Main.fecha, url, Main.currentUser);
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
