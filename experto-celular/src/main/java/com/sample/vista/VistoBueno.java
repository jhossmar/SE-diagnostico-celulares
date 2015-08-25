package com.sample.vista;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class VistoBueno extends JDialog {

	JLabel labelImagen;
	JLabel texto;
	VistaPrincipal vista;

	public VistoBueno(VistaPrincipal vista) {
		super(vista, "Agregado");
		this.setModal(true);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(vista);

		this.labelImagen = new JLabel();
		this.labelImagen.setIcon(new ImageIcon("img/Bien.png"));

		this.texto = new JLabel("Se inserto Correctamente");

		this.add(labelImagen);
		this.add(texto);

		this.setSize(300, 150);
	}

	
	
	public void mostrar() {
		Thread t = new Thread(new Runnable() {

			public void run() {

				setVisible(true);
			}
		});

		Thread s = new Thread(new Runnable() {

			public void run() {
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				dispose();
			}
		});

		t.start();
		s.start();
	}

	public void cerrar() {
		this.dispose();
	}
}
