package com.sample.vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(430, 440));
		this.setBackground(Color.BLUE);
		this.add(new JLabel("hola com o"));
	}
}
