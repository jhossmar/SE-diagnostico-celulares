package com.sample.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Color;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 633, 21);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmDocumento = new JMenuItem("Documento");
		mnAbout.add(mntmDocumento);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBackground(Color.MAGENTA);
		lblImagen.setBounds(30, 88, 377, 229);
		contentPane.add(lblImagen);
		
		JLabel lblIngreseElLfjdksajkl = new JLabel("Ingrese El lfjdksajkl");
		lblIngreseElLfjdksajkl.setBounds(30, 331, 169, 21);
		contentPane.add(lblIngreseElLfjdksajkl);
		
		JPanel panelCuestionarioParaCambiar = new JPanel();
		panelCuestionarioParaCambiar.setBounds(448, 61, 398, 413);
		contentPane.add(panelCuestionarioParaCambiar);
		
		JLabel lblNewLabel = new JLabel("Diagnostico para Celulares");
		lblNewLabel.setBounds(26, 35, 367, 42);
		contentPane.add(lblNewLabel);
	}
}
