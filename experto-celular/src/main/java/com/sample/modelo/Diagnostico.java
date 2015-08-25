package com.sample.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Diagnostico {
	
	 private List estados;
	 private String conclusion;
	 
	 
	 public  Diagnostico() {
		estados = new ArrayList();
	 }
	 
	 public void agregarProblema(Problema problema) {
		 this.estados.add(problema);
	 }

	public List getEstados() {
		return estados;
	}

	public void setEstados(List estados) {
		this.estados = estados;
	}
	
	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public static void main(String[] args) {
		KieServices ks = KieServices.Factory.get();
 	    KieContainer kContainer = ks.getKieClasspathContainer();
     	KieSession kSession = kContainer.newKieSession("ksession-rules");
     	
     	Problema a  = new Problema(TipoEstado.NO_NOS_ESCUCHAN);
     	//Problema b  = new Problema(TipoEstado.NO_ESCUCHAN_CON_AUDIFONOS);
     	
     	Diagnostico diagnostico = new Diagnostico();
     	
     	kSession.setGlobal("diagnostico", diagnostico);
     	
     	kSession.insert(a);
     	//kSession.insert(b);
     	
     	kSession.fireAllRules();
     	
     	System.out.println(diagnostico.getEstados().size());
	}
}
