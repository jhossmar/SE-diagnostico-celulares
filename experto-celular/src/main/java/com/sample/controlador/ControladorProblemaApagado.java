package com.sample.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.kie.api.runtime.KieSession;

import com.sample.modelo.Mapeador;
import com.sample.modelo.MapeadorProblemaApagado;
import com.sample.modelo.Problema;
import com.sample.modelo.TipoEstado;
import com.sample.vista.PanelProblemaApagado;
import com.sample.vista.PanelProblemaAudio;
import com.sample.vista.VistaPrincipal;
import com.sample.vista.VistoBueno;

public class ControladorProblemaApagado implements ActionListener {
	KieSession sesion;
	PanelProblemaApagado panelApagado;
	VistaPrincipal frame;
	VistoBueno mensaje;

	MapeadorProblemaApagado mapeador = new MapeadorProblemaApagado();

	public ControladorProblemaApagado(ConfiguracionDrools drools,
			PanelProblemaApagado panelApagado, VistaPrincipal frame) {
		this.sesion = drools.obtenerNuevaSesionDrools();

		this.panelApagado = panelApagado;

		this.sesion.setGlobal("vista", this.panelApagado);

		this.panelApagado.agregarEventoAceptar(this);

		this.frame = frame;
		this.mensaje = new VistoBueno(this.frame);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == panelApagado.botonAceptar) {

			String llave = panelApagado.comboProblemas.getSelectedItem().toString();
			Problema problema = mapeador.obtenerProblema(llave);

			mensaje.mostrar();

			this.sesion.insert(problema);
			this.sesion.fireAllRules();

		}

	}

}
