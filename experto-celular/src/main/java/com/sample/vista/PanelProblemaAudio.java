package com.sample.vista;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import sun.security.krb5.internal.PAEncTSEnc;

public class PanelProblemaAudio extends JPanel {
	
	JPanel panelPrincipal;
	
	
	public PanelProblemaAudio() {
		
		JPanel p1 = crearPanel();
		
		JPanel p2 = crearPanel();
		
		//panelPrincipal = new JPanel(new CardLayout());
		
		this.setLayout(new CardLayout());
		
		this.add(p1, "primero");
		this.add(p2, "segundo");
	
		
		//add(panelPrincipal);
//		setLayout(null);
//		ButtonGroup a = new ButtonGroup();
//		
//		panelPrincipal =new JPanel(new CardLayout());
//		
//		JLabel lblProblemaDeAudio = new JLabel("Problema de Audio");
//		lblProblemaDeAudio.setFont(new Font("Tahoma", Font.PLAIN, 24));
//		lblProblemaDeAudio.setBounds(113, 11, 206, 44);
//		add(lblProblemaDeAudio);
//		
//		JLabel lblNosEscuchanPero = new JLabel("Nos escuchan pero no escuchamos nada al realizar una llamada"
//				+ "???");
//		lblNosEscuchanPero.setBounds(33, 79, 450, 26);
//		add(lblNosEscuchanPero);
//		
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("si");
//		rdbtnNewRadioButton.setBounds(44, 131, 109, 23);
//		add(rdbtnNewRadioButton);
//		
//		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("no");
//		rdbtnNewRadioButton_1.setBounds(183, 131, 109, 23);
//		add(rdbtnNewRadioButton_1);
//		
//		JButton boton = new JButton("Aceptar");
//		boton.setBounds(183, 131, 109, 23);
//		
//		a.add(rdbtnNewRadioButton);
//		a.add(rdbtnNewRadioButton_1);
	}
	
	public JPanel crearPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		ButtonGroup a = new ButtonGroup();
		
		
		
		JLabel lblProblemaDeAudio = new JLabel("Problema de Audio");
		lblProblemaDeAudio.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblProblemaDeAudio.setBounds(113, 11, 206, 44);
		panel.add(lblProblemaDeAudio);
		
		JLabel lblNosEscuchanPero = new JLabel("Nos escuchan pero no escuchamos nada al realizar una llamada"
				+ "???");
		lblNosEscuchanPero.setBounds(33, 79, 450, 26);
		panel.add(lblNosEscuchanPero);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("si");
		rdbtnNewRadioButton.setBounds(44, 131, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("no");
		rdbtnNewRadioButton_1.setBounds(183, 131, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JButton boton = new JButton("Aceptar");
		boton.setBounds(183, 131, 109, 23);
		
		
		a.add(rdbtnNewRadioButton);
		a.add(rdbtnNewRadioButton_1);
		return panel;
	}
	
	public static void main(String[] args) {
		JFrame a = new JFrame();
		PanelProblemaAudio b = new PanelProblemaAudio();
		a.getContentPane().add(b);
		a.setVisible(true);
	}
}
