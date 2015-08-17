package com.sample.vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutDemo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel cards;
	String BUTTONPANEL = "Card with JButtons";
	String TEXTPANEL = "Card with JTextField";

	public CardLayoutDemo() {

		JPanel p = new JPanel();

		JButton boton1 = new JButton("panel1");
		boton1.addActionListener(this);
		p.add(boton1);

		JButton boton2 = new JButton("panel2");
		boton2.addActionListener(this);
		p.add(boton2);

		JPanel card1 = new JPanel();
		card1.add(new JButton("Button 1"));
		card1.add(new JButton("Button 2"));
		card1.add(new JButton("Button 3"));

		JPanel card2 = new JPanel();
		card2.add(new JTextField("TextField", 20));

		cards = new JPanel(new CardLayout());
		cards.add(card1, BUTTONPANEL);
		cards.add(card2, TEXTPANEL);

		add(p, BorderLayout.PAGE_START);
		add(cards, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		CardLayoutDemo c;
		c = new CardLayoutDemo();
		c.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getActionCommand().compareTo("panel1") == 0) {
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, TEXTPANEL);
		}
		if (ae.getActionCommand().compareTo("panel2") == 0) {
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, BUTTONPANEL);
		}
	}
}
