package com.sample.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.sample.modelo.Diagnostico;
import com.sample.modelo.Problema;
import com.sample.modelo.TipoEstado;
import com.sample.vista.PanelProblemaAudio;
import com.sample.vista.VistaPrincipal;


public class ControladorPrincipal implements ActionListener {
  Diagnostico diagnostico = null; //modelo
   
   VistaPrincipal vistaPrincipal;
	ConfiguracionDrools drools;
	
  public ControladorPrincipal(Diagnostico diag, VistaPrincipal vista) {
     this.diagnostico= diag;
     this.vistaPrincipal= vista;
     //actionListener(this); // escuchador para la vista
     
  }

    //constructor beimar
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
		}
		
	}




}// fin de la clase







	
	/**
	private void actionListener(ControladorPrincipal controladorPrincipal) {
	
		vista.btnIniciarDiagnostico.setActionCommand("cmd_Iniciar_Diagnostico");
		vista.btnIniciarDiagnostico.addActionListener(controladorPrincipal);
	    
		vista.comboBox_tipo_problema.addActionListener(controladorPrincipal);
	
    }

 
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if( comando.equals("cmd_Iniciar_Diagnostico") ){
	        
			System.out.println(vista.comboBox_tipo_problema.getSelectedIndex());
			if(vista.comboBox_tipo_problema.getSelectedIndex()==0)
	        {
			 	System.out.println("Se inicio el diagnostico para problemas de CARGA");
	            // todo lo de problemas de carga(Marcelo Torrico) 
	        }       
			if(vista.comboBox_tipo_problema.getSelectedIndex()==1)
		    {
				System.out.println("Se inicio el diagnostico para problemas de  AUDIO");
		       // todo lo de problemas de audio (Beimar)
		    
		    }
			if(vista.comboBox_tipo_problema.getSelectedIndex()==2)
		    {
			    System.out.println("Se inicio el diagnostico para problemas de  DISPLAY");
		        vista.btnIniciarDiagnostico.setVisible(false);
		        iniciarPreguntas();
			    //vista.setPanelPreguntas(3); // problemas de Display
		        
		    
		    
		    }
			if(vista.comboBox_tipo_problema.getSelectedIndex()==3)
		    {
				System.out.println("Se inicio el diagnostico para problemas de  APAGADO ");
		        // todo lo de problemas de apagado (Fernando)
		    }








	
	
	


	private void iniciarPreguntas() {
	   int a = preguntar("Su celular es del tipo  con tapa?");
	   int b = preguntar("Su celular es del tipo  con slide?");
	   int c= preguntar("Su celular se enciende y se apaga de repente?");
	
	  // diagnostico.addEstados();
	
	}


	private int preguntar(String pregunta) {
		int choice = JOptionPane.showOptionDialog(null,
				  "su celular es del tipo con tapa?", 
				  pregunta, 
			      JOptionPane.YES_NO_OPTION, 
			      JOptionPane.QUESTION_MESSAGE, 
			      null, null, null);
		   if (choice == JOptionPane.YES_OPTION)
			  {
			    return 1;
			  }else{
				  return 0;
			  }
	
	}


	public void go()
    {
        this.vista.setVisible(true);
    }
	
}
**/
