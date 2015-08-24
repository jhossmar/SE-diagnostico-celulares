package com.sample.modelo;

import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Diagnostico {
	 private Problema estado;
	 private List estados;
	 
	 public  Diagnostico(Problema estado) {
		 Problema a = new Problema(TipoEstado.MEMORIA);
    }

	public Problema getEstado() {
		return estado;
	}

	public void setEstado(Problema estado) {
		this.estado = estado;
	}
}
