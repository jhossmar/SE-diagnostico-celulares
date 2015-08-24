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

	

	public ControladorProblemaAudio(ConfiguracionDrools drools,
			PanelProblemaAudio panelAudio, VistaPrincipal frame) {
		this.sesion = drools.obtenerNuevaSesionDrools();

		this.panelAudio = panelAudio;

		this.sesion.setGlobal("vista", this.panelAudio);

		this.panelAudio.agregarEventoAceptar(this);

		this.frame = frame;
		this.mensaje = new VistoBueno(this.frame);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == panelAudio.botonAceptar) {
			if (panelAudio.radioSi.isSelected()) {

				mensaje.mostrar();

				Problema pro = new Problema(TipoEstado.REALIZA_LLAMADA);
				this.sesion.insert(pro);
				this.sesion.fireAllRules();
			} else {
				JOptionPane.showConfirmDialog(frame,
						"Su celular no tiene señal");
				mensaje.dispose();
			}

		}

	}

	
}
