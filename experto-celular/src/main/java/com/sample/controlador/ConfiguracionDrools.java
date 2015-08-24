package com.sample.controlador;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ConfiguracionDrools {
	KieServices ks;
	KieContainer kContainer;
	
	public ConfiguracionDrools() {
		leerBaseConocimientos();
	}
	
	public void leerBaseConocimientos() {
		ks = KieServices.Factory.get();
	    kContainer = ks.getKieClasspathContainer();
	}
	
	public KieSession obtenerNuevaSesionDrools() {
		KieSession sesion = null;
		
		try {
			sesion = this.kContainer.newKieSession("ksession-rules");
		} catch(Throwable t) {
			t.printStackTrace();
		}
		return sesion;
	}
}
