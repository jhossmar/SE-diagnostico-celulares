package com.sample.vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import sun.security.krb5.internal.PAEncTSEnc;

public class PanelProblemaAudio extends JPanel {
	
	public JDialog dlg;
	
	JPanel panelPregunta;
	JPanel panelAceptar;
	JPanel panelSugerencia;
	
	public JLabel labelpregunta;
	
	public JLabel labelSugerencia;
	
	public JRadioButton radioSi;
	public JRadioButton radioNo;
	
	public JButton botonAceptar;
	
	public JComboBox comboProblemas;
	
	public PanelProblemaAudio() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(430, 440));
		//this.setBackground(Color.BLUE);
		
		
		panelPregunta = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelpregunta = new JLabel("Se pueden Realizar Llamadas??");
		ButtonGroup grupo = new ButtonGroup();
		radioSi = new JRadioButton("SI");
		radioNo = new JRadioButton("NO");
		grupo.add(radioSi);
		grupo.add(radioNo);
		
		panelPregunta.add(labelpregunta);
		panelPregunta.add(radioSi);
		panelPregunta.add(radioNo);
		
		this.add(panelPregunta, BorderLayout.NORTH);
		
		panelAceptar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		botonAceptar = new JButton("Aceptar");
		panelAceptar.add(botonAceptar);
		
		panelSugerencia = new JPanel(new FlowLayout());
		labelSugerencia = new JLabel("Sugerencias");
		panelSugerencia.add(labelSugerencia);
		
		this.add(panelSugerencia, BorderLayout.CENTER);
		this.add(botonAceptar, BorderLayout.SOUTH);
	}
	
	public void cambiarSugerencia(String texto) {
		this.labelSugerencia.setText(texto);
	}
	
	public void agregarEventoAceptar(ActionListener action) {
		this.botonAceptar.addActionListener(action);
	}
	
	public void cambiarElementos(){
		//limpia el panel
		this.panelPregunta.removeAll();
		this.panelPregunta.repaint();
		SwingUtilities.updateComponentTreeUI(this);
		
		this.panelPregunta.add(crearPanel());
	}
	
	public JPanel crearPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JLabel pregunta = new JLabel("Inserte Hechos: ");
		panel.add(pregunta);
		
		this.comboProblemas = new JComboBox();
		String[] problemas = new String[]{"Nos escuchan","No nos escuchan",
				"Conectores LImpios"};
		
		this.comboProblemas.setModel(new DefaultComboBoxModel(problemas));
		panel.add(comboProblemas);
		
		return panel;
	}
}
