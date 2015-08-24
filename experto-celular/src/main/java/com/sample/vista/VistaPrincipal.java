package com.sample.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class VistaPrincipal extends JFrame {

	 JPanel contentPane;
	public JComboBox comboBox_tipo_problema;
	public JButton btnIniciarDiagnostico;
	private JPanel panelCuestionarioParaCambiar;

   /**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 867, 21);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mnArchivo.add(mntmCerrar);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmDocumento = new JMenuItem("Documento");
		mnAbout.add(mntmDocumento);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBackground(Color.MAGENTA);
		lblImagen.setBounds(30, 88, 377, 201);
		contentPane.add(lblImagen);
		
		//panelCuestionarioParaCambiar = new JPanel();
		
		
		JLabel lblNewLabel = new JLabel("Diagnostico para Celulares");
		lblNewLabel.setBounds(26, 35, 367, 42);
		contentPane.add(lblNewLabel);
		
		comboBox_tipo_problema = new JComboBox();
		comboBox_tipo_problema.setModel(new DefaultComboBoxModel(new String[] {"Problemas de Carga", "Problemas de Audio", "Problemas de Display", "Problemas de Apagado"}));
		comboBox_tipo_problema.setBounds(193, 336, 214, 24);
		contentPane.add(comboBox_tipo_problema);
		
		JLabel lblTipoDeProblema = new JLabel("TIPO DE PROBLEMA ");
		lblTipoDeProblema.setBounds(30, 341, 158, 15);
		contentPane.add(lblTipoDeProblema);
		
		btnIniciarDiagnostico = new JButton("Iniciar Diagnostico");
		btnIniciarDiagnostico.setBounds(193, 388, 214, 25);
		contentPane.add(btnIniciarDiagnostico);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(UIManager.getColor("Checkbox.select"));
		separator.setForeground(UIManager.getColor("ColorChooser.foreground"));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(476, 486, 17, -465);
		contentPane.add(separator);
	}

   /**
    * metodo para cambiar el panel de preguntas
    * 
    * @param tipo_problema  1 problemas de carga, 
    *                        2 problemas de audio
    *                        3 problemas de display
    *                        4 problemas de apagado
    * */
	public void setPanelPreguntas(int tipo_problema) {
	  switch (tipo_problema) {
	    case 1:
		          // cambiar al panel de problemas de carga
		       break;
	    case 2:
			   // cambiar al paner de problemas de audio
			   break;
  
	    case 3:
	    	  // panelCuestionarioParaCambiar = new Panel_Preguntas_Display();
	    	   //panelCuestionarioParaCambiar.setBounds(436, 33, 398, 413);
	   		   //contentPane.add(panelCuestionarioParaCambiar);
	    	   this.repaint();
			   System.out.println("Se  cambio al panel 3");
	    	   break;
	    case 4:
			
	    	   // cambiar al panel de problemas de apagado
			   break;
 
     	default:
	     	break;
	   }
	}
}// fin clase
