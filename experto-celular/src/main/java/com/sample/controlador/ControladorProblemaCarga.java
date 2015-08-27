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
					panelCarga.agregarSugerencia("El celula puede recargar la bateria");
				}else if(panelCarga.radioNo.isSelected()){
					mensaje.mostrar();

					Problema pro = new Problema(TipoEstado.NO_RECARGA_BATERIA);
					this.sesion.insert(pro);
					this.sesion.fireAllRules();
					
					bandera = false;
					carga.setEtapa("estadoConector");
					panelCarga.agregarSugerencia("El celula no puede recargar la bateria");
				}else{
					JOptionPane.showMessageDialog(null, "Seleccione alguna opcion");
				}
			}else{
				String etapa = carga.getEtapa();
				if(etapa == "duracion"){
					
					if (panelCarga.radioSi.isSelected()) {
						Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
						this.sesion.insert(pro);
						this.sesion.fireAllRules();
						bandera = true;
						panelCarga.agregarSugerencia("La bateria dura poco tiempo");
						panelCarga.agregarSugerencia("Muchas aplicaciones abiertas");
						JOptionPane.showMessageDialog(null, "El problema de carga son las aplicaciones que esten abiertas");
					}else if(panelCarga.radioNo.isSelected()){
						Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
						this.sesion.insert(pro);
						this.sesion.fireAllRules();
						bandera = true;
						panelCarga.agregarSugerencia("La bateria dura lo normal");
						panelCarga.agregarSugerencia("No se encuentra problemas de carga");
						JOptionPane.showMessageDialog(null, "No hay problema de carga");	
					}else{
						JOptionPane.showMessageDialog(null, "Seleccione alguna opcion");
					}
				}else{
					if(etapa == "estadoConector"){
						
						if (panelCarga.radioSi.isSelected()) {
							mensaje.mostrar();
							Problema pro = new Problema(TipoEstado.FUSIBLE_CARGA);
							this.sesion.insert(pro);
							this.sesion.fireAllRules();
							carga.setEtapa("fusibleCarga");
							panelCarga.agregarSugerencia("El conector de la bateria esta en buen estado");
						}else if(panelCarga.radioNo.isSelected()){
							Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
							this.sesion.insert(pro);
							this.sesion.fireAllRules();
							bandera = true;
							panelCarga.agregarSugerencia("El conector de la bateria no esta en buen estado");
							panelCarga.agregarSugerencia("El problema es el conector de la bateria");
							JOptionPane.showMessageDialog(null, "El problema es el conector de la bateria");
						}else{
							JOptionPane.showMessageDialog(null, "Seleccione alguna opcion");
						}
					}else{
						if(etapa == "fusibleCarga"){
							if (panelCarga.radioSi.isSelected()) {
								Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
								this.sesion.insert(pro);
								this.sesion.fireAllRules();
								bandera = true;
								panelCarga.agregarSugerencia("El fusible de la carga esta dañado");
								panelCarga.agregarSugerencia("El problema es el fusible de carga");
								JOptionPane.showMessageDialog(null, "El problema es el fusible de carga");
								
							}else if(panelCarga.radioNo.isSelected()){
								mensaje.mostrar();
								Problema pro = new Problema(TipoEstado.CONTINUIDAD_EXTREMOS);
								this.sesion.insert(pro);
								this.sesion.fireAllRules();
								carga.setEtapa("adaptadorCelular");
								panelCarga.agregarSugerencia("El fusible de la carga no esta dañado");
							}else{
								JOptionPane.showMessageDialog(null, "Seleccione alguna opcion");
							}
						}else{
							if(etapa == "adaptadorCelular"){
								if (panelCarga.radioSi.isSelected()){
									Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
									this.sesion.insert(pro);
									this.sesion.fireAllRules();
									bandera = true;
									panelCarga.agregarSugerencia("Los extremos del fusible no funcionan");
									panelCarga.agregarSugerencia("El problema son los extremos del fusible");
									JOptionPane.showMessageDialog(null, "El problema son los extremos del fusible");
									
								}else if(panelCarga.radioNo.isSelected()){
									mensaje.mostrar();
									Problema pro = new Problema(TipoEstado.ADAPTADOR_CELULAR);
									this.sesion.insert(pro);
									this.sesion.fireAllRules();
									carga.setEtapa("ultimo");
									panelCarga.agregarSugerencia("Los extremos del fusible si funcionan");
								}else{
									JOptionPane.showMessageDialog(null, "Seleccione alguna opcion");
								}
							}else{
								if(etapa == "ultimo"){
									if (panelCarga.radioSi.isSelected()){
										Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
										this.sesion.insert(pro);
										this.sesion.fireAllRules();
										bandera = true;
										panelCarga.agregarSugerencia("El adaptador del celular esta en buen estado");
										panelCarga.agregarSugerencia("La bateria esta muerta");
										JOptionPane.showMessageDialog(null, "La bateria esta muerta");
										
									}else if(panelCarga.radioNo.isSelected()){
										Problema pro = new Problema(TipoEstado.DIAGNOSTICO_CARGA);
										this.sesion.insert(pro);
										this.sesion.fireAllRules();
										bandera = true;
										panelCarga.agregarSugerencia("El adaptador del celular no esta en buen estado");
										panelCarga.agregarSugerencia("El problema es el adaptador del celular");
										JOptionPane.showMessageDialog(null, "El problema es el adaptador del celular");
									}else{
										JOptionPane.showMessageDialog(null, "Seleccione alguna opcion");
									}
								}
							}
						}
					}
				}
			}	
		}
	}
}
