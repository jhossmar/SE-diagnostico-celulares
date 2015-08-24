package com.sample.controlador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sample.vista.PantallaCargandoMain;
import com.sample.vista.VistaPrincipal;

public class ClasePrincipal {
	
	public static void cambiarLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		cambiarLookAndFeel();
		
		VistaPrincipal vistaPrincipal = new VistaPrincipal();

		ControladorPrincipal controlador = new ControladorPrincipal(vistaPrincipal);
		new PantallaCargandoMain();
		vistaPrincipal.iniciar();
		
		

	}
}
