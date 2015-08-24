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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import sun.security.krb5.internal.PAEncTSEnc;

public class PanelProblemaAudio extends JPanel {
	
	JPanel panelPregunta;
	JPanel panelAceptar;
	JPanel panelSugerencia;
	
	public JLabel labelpregunta;
	
	public JLabel labelSugerencia;
	
	public JRadioButton radioSi;
	public JRadioButton radioNo;
	
	public JButton botonAceptar;
	
	public PanelProblemaAudio() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(430, 440));
		//this.setBackground(Color.BLUE);
		
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelpregunta = new JLabel("Se pueden Realizar Llamadas??");
		ButtonGroup grupo = new ButtonGroup();
		radioSi = new JRadioButton("SI");
		radioNo = new JRadioButton("NO");
		grupo.add(radioSi);
		grupo.add(radioNo);
		
		panel.add(labelpregunta);
		panel.add(radioSi);
		panel.add(radioNo);
		
		this.add(panel, BorderLayout.NORTH);
		
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
}
