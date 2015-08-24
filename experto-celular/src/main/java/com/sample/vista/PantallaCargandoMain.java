package com.sample.vista;



import javax.swing.ImageIcon;

public class PantallaCargandoMain {

	PantallaCargando screen;

	public PantallaCargandoMain() {
		inicioPantalla();
		screen.velocidadDeCarga();
		screen.setSize(200, 300);
	}

	private void inicioPantalla() {
		ImageIcon myImage = new ImageIcon("img/umss.jpg");
		screen = new PantallaCargando(myImage);
		screen.setLocationRelativeTo(null);
		screen.setProgresoMax(70);
		screen.setVisible(true);
	}
}
