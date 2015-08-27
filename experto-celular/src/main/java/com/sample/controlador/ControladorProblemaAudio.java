package com.sample.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.kie.api.runtime.KieSession;

import com.sample.modelo.Mapeador;
import com.sample.modelo.Problema;
import com.sample.modelo.TipoEstado;
import com.sample.vista.PanelProblemaAudio;
import com.sample.vista.PantallaCargandoMain;
import com.sample.vista.VistaPrincipal;
import com.sample.vista.VistoBueno;

public class ControladorProblemaAudio implements ActionListener{

	KieSession sesion;
	PanelProblemaAudio panelAudio;
	VistaPrincipal frame;
	VistoBueno mensaje;

	Mapeador mapeador = new Mapeador();
	
	boolean bandera = true;

	public ControladorProblemaAudio(ConfiguracionDrools drools,
			PanelProblemaAudio panelAudio, VistaPrincipal frame) {
		this.sesion = drools.obtenerNuevaSesionDrools();

		this.panelAudio = panelAudio;

		this.sesion.setGlobal("vistaaudio", this.panelAudio);

		this.panelAudio.agregarEventoAceptar(this);

		this.frame = frame;
		this.mensaje = new VistoBueno(this.frame);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == panelAudio.botonAceptar) {
			
			if(!bandera) {
				String llave = panelAudio.comboProblemas.getSelectedItem().toString();
				Problema problema = mapeador.obtenerProblema(llave);
				
				mensaje.mostrar();
				
				this.sesion.insert(problema);
				this.sesion.fireAllRules();
				
			}
			
			if (panelAudio.radioSi.isSelected() && bandera) {

				mensaje.mostrar();

				Problema pro = new Problema(TipoEstado.REALIZA_LLAMADA);
				this.sesion.insert(pro);
				this.sesion.fireAllRules();
				
				bandera = false;
				
			} else if(panelAudio.radioNo.isSelected()) {
				JOptionPane.showMessageDialog(null, "Debe conectarse a una linea");
				
			}
			
			

		}

	}
	
	public void actualizarFoco() {
		this.frame.setFocusable(true);
		this.frame.requestFocusInWindow();
	}

	
}
