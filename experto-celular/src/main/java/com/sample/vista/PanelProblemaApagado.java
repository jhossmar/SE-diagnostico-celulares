package com.sample.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import com.sample.controlador.ControladorProblemaApagado;

public class PanelProblemaApagado extends JPanel{
	
	
public JDialog dlg;
	
	JPanel panelPregunta;
	JPanel panelAceptar;
	JPanel panelSugerencia;
	
	public JLabel labelpregunta;
	
	public JLabel labelSugerencia;
	
	public JButton botonAceptar;
	
	public JComboBox comboProblemas;
	
	public PanelProblemaApagado() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(430, 440));
		//this.setBackground(Color.BLUE);
		
		
		panelPregunta = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labelpregunta = new JLabel("Se pueden Realizar Llamadas??");
		
		panelPregunta.add(labelpregunta);
		
		this.add(panelPregunta, BorderLayout.NORTH);
		
		panelAceptar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setFont(new Font("Tahoma", 0, 20));
		botonAceptar.setFocusable(false);
		panelAceptar.add(botonAceptar);
		
		JLabel titulo = new JLabel("Sugerencias");
		
		panelSugerencia = new JPanel(new BorderLayout());
		labelSugerencia = new JLabel("");
		panelSugerencia.add(titulo, BorderLayout.NORTH);
		panelSugerencia.add(labelSugerencia, BorderLayout.CENTER);
		
		this.add(panelSugerencia, BorderLayout.CENTER);
		this.add(botonAceptar, BorderLayout.SOUTH);
		
		this.cambiarElementos();
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
	
	public void cambiarElementos(){
		//limpia el panel
		this.panelPregunta.removeAll();
		this.panelPregunta.repaint();
		SwingUtilities.updateComponentTreeUI(this);
		
		this.panelPregunta.add(crearPanel());
	}
	
	public JPanel crearPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JLabel pregunta = new JLabel("Inserte Informacion: ");
		panel.add(pregunta);
		
		this.comboProblemas = new JComboBox();
		String[] problemas = new String[]{"El telefono se apaga solo",
				"Se Reinicia al realizar una llamada",
				"El Amplificador de Potencia esta Reemplazado", 
				"Se cuelga cuando se entra en un menu especial",
				"Se Reinicia solo", "El software esta actualizado"};
		
		this.comboProblemas.setModel(new DefaultComboBoxModel(problemas));
		panel.add(comboProblemas);
		
		return panel;
	}
	
	
}
