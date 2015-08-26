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

import com.sample.modelo.Carga;
import com.sample.modelo.Problema;
import com.sample.modelo.TipoEstado;
import com.sample.vista.PanelProblemaCarga;
import com.sample.vista.PantallaCargandoMain;
import com.sample.vista.VistaPrincipal;
import com.sample.vista.VistoBueno;

public class ControladorProblemaCarga implements ActionListener{
	
	KieSession sesion;
	PanelProblemaCarga panelCarga;
	VistaPrincipal frame;
	VistoBueno mensaje;
	Carga carga = new Carga();
	
	boolean bandera = true;

	public ControladorProblemaCarga(ConfiguracionDrools drools,
			PanelProblemaCarga panelCarga, VistaPrincipal frame) {
		this.sesion = drools.obtenerNuevaSesionDrools();

		this.panelCarga = panelCarga;
		
		Carga carga = new Carga();

		this.sesion.setGlobal("vistaCarga", this.panelCarga);
		this.sesion.setGlobal("carga",carga);

		this.panelCarga.agregarEventoAceptar(this);

		this.frame = frame;
		this.mensaje = new VistoBueno(this.frame);	
	}
	public void actionPerformed(ActionEvent arg0){
		if (arg0.getSource() == panelCarga.botonAceptar){
			
			if(bandera){
				if (panelCarga.radioSi.isSelected()) {
					
					mensaje.mostrar();

					Problema pro = new Problema(TipoEstado.RECARGA_BATERIA);
					this.sesion.insert(pro);
					this.sesion.fireAllRules();
					
					bandera = false;
					carga.setEtapa("duracion");
				}else if(panelCarga.radioNo.isSelected()){
					mensaje.mostrar();

					Problema pro = new Problema(TipoEstado.NO_RECARGA_BATERIA);
					this.sesion.insert(pro);
					this.sesion.fireAllRules();
					
					bandera = false;
					carga.setEtapa("estadoConector");
				}
			}else{
				String etapa = carga.getEtapa();
				if(etapa == "duracion"){
					
					if (panelCarga.radioSi.isSelected()) {
						Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
						this.sesion.insert(pro);
						this.sesion.fireAllRules();
						bandera = true;
						JOptionPane.showMessageDialog(null, "El problema de carga son las aplicaciones que esten abiertas");
					}else if(panelCarga.radioNo.isSelected()){
						Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
						this.sesion.insert(pro);
						this.sesion.fireAllRules();
						bandera = true;
						JOptionPane.showMessageDialog(null, "No hay problema de carga");	
					}
				}else{
					if(etapa == "estadoConector"){
						
						if (panelCarga.radioSi.isSelected()) {
							Problema pro = new Problema(TipoEstado.FUSIBLE_CARGA);
							this.sesion.insert(pro);
							this.sesion.fireAllRules();
							carga.setEtapa("extremosFusiles");
						}else if(panelCarga.radioNo.isSelected()){
							Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
							this.sesion.insert(pro);
							this.sesion.fireAllRules();
							bandera = true;
							JOptionPane.showMessageDialog(null, "El problema es el conector de la bateria");
						}
					}else{
						if(etapa == "extremosFusiles"){
							if (panelCarga.radioSi.isSelected()) {
								Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
								this.sesion.insert(pro);
								this.sesion.fireAllRules();
								bandera = true;
								JOptionPane.showMessageDialog(null, "El problema esta en los extremos del fusible. Hay que reemplazarlos");
								
							}else if(panelCarga.radioNo.isSelected()){
								Problema pro = new Problema(TipoEstado.CONTINUIDAD_EXTREMOS);
								this.sesion.insert(pro);
								this.sesion.fireAllRules();
								carga.setEtapa("adaptadorCelular");
							}
						}else{
							if(etapa == "adaptadorCelulares"){
								if (panelCarga.radioSi.isSelected()){
									Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
									this.sesion.insert(pro);
									this.sesion.fireAllRules();
									bandera = true;
									JOptionPane.showMessageDialog(null, "La bateria del celular esta muerta");
									
								}else if(panelCarga.radioNo.isSelected()){
									Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
									this.sesion.insert(pro);
									this.sesion.fireAllRules();
									bandera = true;
									JOptionPane.showMessageDialog(null, "El problema es el adaptador del celular");
								}
							}
						}
					}
				}
			}	
		}
	}
}
