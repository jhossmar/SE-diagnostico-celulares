package com.sample.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ConclusionAudio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConclusionAudio frame = new ConclusionAudio();
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
	public ConclusionAudio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProblemaDeAudio = new JLabel("Problema de Audio");
		lblProblemaDeAudio.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProblemaDeAudio.setBounds(158, 22, 230, 24);
		contentPane.add(lblProblemaDeAudio);
		
		JLabel lblConclusion = new JLabel("Conclusion");
		lblConclusion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConclusion.setBounds(39, 78, 99, 24);
		contentPane.add(lblConclusion);
		
		JLabel lblTextoParaCambiar = new JLabel("Texto para cambiar");
		lblTextoParaCambiar.setBounds(39, 124, 266, 24);
		contentPane.add(lblTextoParaCambiar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(39, 242, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon("img/descarga.jpg"));
		lblImagen.setBounds(281, 86, 206, 179);
		contentPane.add(lblImagen);
	}
}
