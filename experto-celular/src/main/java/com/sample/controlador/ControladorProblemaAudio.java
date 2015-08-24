package com.sample.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.kie.api.runtime.KieSession;

import com.sample.modelo.Problema;
import com.sample.modelo.TipoEstado;
import com.sample.vista.PanelProblemaAudio;

public class ControladorProblemaAudio implements ActionListener{
	
	KieSession sesion;
	PanelProblemaAudio panelAudio;
	
	public ControladorProblemaAudio(ConfiguracionDrools drools, PanelProblemaAudio panelAudio) {
		this.sesion = drools.obtenerNuevaSesionDrools();
		
		this.panelAudio = panelAudio;
		
		this.sesion.setGlobal("vista", this.panelAudio);
		
		this.panelAudio.agregarEventoAceptar(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == panelAudio.botonAceptar) {
			if(panelAudio.radioSi.isSelected()) {
				Problema pro = new Problema(TipoEstado.REALIZA_LLAMADA);
				this.sesion.insert(pro);
				this.sesion.fireAllRules();
			} else {
				JOptionPane.showConfirmDialog(null, "que esta pasasnod");
			}
			
		}
		
	}
}	
