package com.sample.vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.MenuBar;

import javafx.scene.image.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	public JPanel panelParaCambiar;
	public JButton btnAceptar;
	public CardLayout cardLayout;
	public JComboBox comboBox;

	public VistaPrincipal() {
		this.configurarVista();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.iniciarMenu();
		this.agregarImagen();
		

		this.iniciarPanelParaCambiar();
		
		this.iniciarPanelCentral();
		

		
	}
	
	public void cambiarPanel(String panel) {
		this.cardLayout.show(this.panelParaCambiar, panel);
	}
	
	public void iniciarPanelParaCambiar() {
		panelParaCambiar = new JPanel();
		this.cardLayout = new CardLayout();
		panelParaCambiar.setLayout(this.cardLayout);
		panelParaCambiar.setBorder(BorderFactory.createTitledBorder("Panel de Cambio"));
		panelParaCambiar.setBounds(448, 12, 430, 440);
		
		/**
		 * Aqui se agrega los paneles que cambian 
		 */
		panelParaCambiar.add(new JPanel(), "Inicio");
		panelParaCambiar.add(new PanelProblemaAudio(), "Audio");
		
		contentPane.add(panelParaCambiar);
	}
	
	

	public void iniciarPanelCentral() {
		JPanel panel = new JPanel();
		panel.setBounds(26, 293, 384, 173);
		contentPane.add(panel);

		JLabel lblNewLabel1 = new JLabel("Indique su Problema: ");
		lblNewLabel1.setBounds(28, 78, 200, 50);
		panel.add(lblNewLabel1);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"Problema de Carga", "Problema con el Audio",
				"Problema con el Display", "Problemas de Apagado" }));
		comboBox.setBounds(164, 92, 181, 22);
		panel.add(comboBox);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(164, 141, 97, 25);

		panel.add(btnAceptar);
	}
	
	public void iniciarMenu() {
		JMenuBar menuBar = new JMenuBar();

		this.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenuItem mntmDocumento = new JMenuItem("Documento");
		mnAbout.add(mntmDocumento);
	}

	public void agregarImagen() {
		JLabel lblNewLabel = new JLabel("Diagnostico para Celulares");
		lblNewLabel.setBounds(26, 35, 367, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon("img/descarga.jpg"));
		lblImagen.setBackground(Color.MAGENTA);
		lblImagen.setBounds(20, 68, 480, 220);
		contentPane.add(lblImagen);
	}
	
	public void agregarEvento(ActionListener action) {
		this.btnAceptar.addActionListener(action);
	}

	public void configurarVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 524);
		this.setResizable(false);
		this.setTitle("Sistemas Expertos-Diagnostico Celulares");
	}

	public void iniciar() {
		this.setVisible(true);
	}
}
