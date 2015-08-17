package com.sample.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
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
	private JPanel panelCuestionarioParaCambiar;

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
		lblImagen.setBounds(30, 88, 380, 159);
		contentPane.add(lblImagen);
		
		panelCuestionarioParaCambiar = new JPanel();
		panelCuestionarioParaCambiar.setBounds(448, 61, 398, 413);
		contentPane.add(panelCuestionarioParaCambiar);
		
		JLabel lblNewLabel = new JLabel("Diagnostico para Celulares");
		lblNewLabel.setBounds(26, 35, 367, 42);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 293, 384, 173);
		contentPane.add(panel);
		
		JLabel lblNewLabel1 = new JLabel("Indique su Problema: ");
		lblNewLabel1.setBounds(28, 78, 200, 50);
		panel.add(lblNewLabel1);	
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Problema de Carga", "Problema con el Audio", "Problema con el Display", "Problemas de Apagado"}));
		comboBox.setBounds(164, 92, 181, 22);
		panel.add(comboBox);
		final VistaPrincipal a = this;
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String problema = (String)comboBox.getSelectedItem();
				if(problema == "Problema de Carga"){
					//carga.setVisible(true);
					a.setPanelCuestionario(new PanelProblemaAudio());
				}
			}
		});
		btnAceptar.setBounds(164, 141, 97, 25);
		
		panel.add(btnAceptar);
	}
	
	public void setPanelCuestionario(PanelProblemaAudio panelNuevo) {
		this.removeAll();
		this.add(panelNuevo);
		this.repaint();
		
		SwingUtilities.updateComponentTreeUI(this);
	}
}
