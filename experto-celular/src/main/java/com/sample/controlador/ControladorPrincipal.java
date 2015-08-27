package com.sample.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sample.modelo.Diagnostico;
import com.sample.modelo.Problema;
import com.sample.modelo.TipoEstado;
import com.sample.vista.PanelProblemaAudio;
import com.sample.vista.PanelProblemaCarga;
import com.sample.vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener{

	VistaPrincipal vistaPrincipal;
	ConfiguracionDrools drools;
	
	public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
		this.vistaPrincipal.agregarEvento(this);
		this.drools = new ConfiguracionDrools();
	}
	
	

	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == vistaPrincipal.btnAceptar) {
			String problema = (String) vistaPrincipal.comboBox.getSelectedItem();
			
			/**
			 * Controla que se cambie el panel de problema de Audio
			 */
			if (problema == "Problema con el Audio") {
				vistaPrincipal.cambiarPanel("Audio");
				ControladorProblemaAudio controlador = new ControladorProblemaAudio(drools, vistaPrincipal.panelAudio, vistaPrincipal);
				
			}
			
			if(problema == "Problema de Carga"){
				vistaPrincipal.cambiarPanel("Carga");
				ControladorProblemaCarga controladorCarga = new ControladorProblemaCarga(drools, vistaPrincipal.panelCarga, vistaPrincipal);
			}
			
			if(problema == "Problemas de Apagado") {
				vistaPrincipal.cambiarPanel("Apagado");
				ControladorProblemaApagado controladorApagado = new ControladorProblemaApagado(drools, vistaPrincipal.panelApagado, vistaPrincipal);
			}
			
		}
		
	}
}
