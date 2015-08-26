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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import sun.security.krb5.internal.PAEncTSEnc;

import com.sample.modelo.Carga;

public class PanelProblemaCarga extends JPanel{
	
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
	
	public PanelProblemaCarga() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(430, 440));
		//this.setBackground(Color.BLUE);
		
		
		panelPregunta = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelpregunta = new JLabel("Se puede recargar la bateria?");
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
		
		JLabel titulo = new JLabel("Sugerencias");
		
		panelSugerencia = new JPanel(new BorderLayout());
		labelSugerencia = new JLabel("");
		panelSugerencia.add(titulo, BorderLayout.NORTH);
		panelSugerencia.add(labelSugerencia, BorderLayout.CENTER);
		
		this.add(panelSugerencia, BorderLayout.CENTER);
		this.add(botonAceptar, BorderLayout.SOUTH);
	}
	
	public void mostrarSugerencia() {
		
		JOptionPane.showMessageDialog(null, labelSugerencia.getText(), "Sugerencia", 1);
	}
	
	public void cambiarSugerencia(String texto) {
		this.labelSugerencia.setText(texto);
	}
	
	public void agregarEventoAceptar(ActionListener action) {
		this.botonAceptar.addActionListener(action);
	}
	
	public void limpiar(){
		
		this.panelPregunta.removeAll();
		this.panelPregunta.repaint();
		SwingUtilities.updateComponentTreeUI(this);
	}
	public void cambiarDuracionBateria(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel pregunta = new JLabel("La carga de la bateria dura poco tiempo?");
		panel.add(pregunta);
		
		ButtonGroup grupo = new ButtonGroup();
		radioSi = new JRadioButton("SI");
		radioNo = new JRadioButton("NO");
		grupo.add(radioSi);
		grupo.add(radioNo);
		
		panel.add(radioSi);
		panel.add(radioNo);
		
		this.panelPregunta.add(panel);
	}
	public void cambiarConectorBateria(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel pregunta = new JLabel("Esta en buen estado el conector de la bateria");
		panel.add(pregunta);
		
		ButtonGroup grupo = new ButtonGroup();
		radioSi = new JRadioButton("SI");
		radioNo = new JRadioButton("NO");
		grupo.add(radioSi);
		grupo.add(radioNo);
		
		panel.add(radioSi);
		panel.add(radioNo);
		
		this.panelPregunta.add(panel);
	}
	public void principio(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel pregunta = new JLabel("Se puede recargar la bateria?");
		panel.add(pregunta);
		
		ButtonGroup grupo = new ButtonGroup();
		radioSi = new JRadioButton("SI");
		radioNo = new JRadioButton("NO");
		grupo.add(radioSi);
		grupo.add(radioNo);
		
		panel.add(radioSi);
		panel.add(radioNo);
		
		this.panelPregunta.add(panel);
	}
	public void cambiarFusibles(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel pregunta = new JLabel("El fusible de carga esta dañado?");
		panel.add(pregunta);
		
		ButtonGroup grupo = new ButtonGroup();
		radioSi = new JRadioButton("SI");
		radioNo = new JRadioButton("NO");
		grupo.add(radioSi);
		grupo.add(radioNo);
		
		panel.add(radioSi);
		panel.add(radioNo);
		
		this.panelPregunta.add(panel);
	}
	public void cambiarFusiblesExtremos(){
		JPanel panel = new JPanel(new FlowLayout());
		JLabel pregunta = new JLabel("Los extremos del fusible estan abiertos(No funcionan)?");
		panel.add(pregunta);
		
		ButtonGroup grupo = new ButtonGroup();
		radioSi = new JRadioButton("SI");
		radioNo = new JRadioButton("NO");
		grupo.add(radioSi);
		grupo.add(radioNo);
		
		panel.add(radioSi);
		panel.add(radioNo);
		
		this.panelPregunta.add(panel);
	}
}
