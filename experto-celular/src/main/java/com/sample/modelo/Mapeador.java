package com.sample.modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Mapeador {
	private Map mapa;
	private boolean habilitado = false;
	
	public Mapeador() {
		this.mapa = new HashMap();
		this.agregarProblemas();
	}
	
	public void agregarProblemas() {
		this.mapa.put("Podemos realizar Llamada", new Problema(TipoEstado.REALIZA_LLAMADA));
		this.mapa.put("No escuchamos nada", new Problema(TipoEstado.NO_ESCUCHAMOS_NADA));
		this.mapa.put("Nos escuchan", new Problema(TipoEstado.NOS_ESCUCHAN));
		this.mapa.put("Los componentes pasivos en buen estado", new Problema(TipoEstado.COMPONENTES_PASIVOS_BUEN_ESTADO));
		this.mapa.put("No nos escuchan", new Problema(TipoEstado.NO_NOS_ESCUCHAN));
		this.mapa.put("No se escucha con audifonos", new Problema(TipoEstado.NO_SE_ESCUCHA_CON_AUDIFONOS));
		this.mapa.put("Conectores Limpios", new Problema(TipoEstado.CONECTORES_LIMPIOS));
	}
	
	public Problema obtenerProblema(String llave) {
		if(!habilitado ) {
			habilitado = true;
			return (Problema) this.mapa.get(llave);
		} else {
			return (Problema) this.mapa.get(llave);
		}
	}
	
	public void recorrer() {
		Iterator iterador = this.mapa.entrySet().iterator();
	    //Iterator<Map.Entry<String, Float>> iterador = listaProductos.entrySet().iterator();
	    Map.Entry producto;
	    while (iterador.hasNext()) {
	        producto = (Map.Entry) iterador.next();
	        //producto = iterador.next(); Si se usase tambien la otra linea comentada.
	        System.out.println(producto.getKey() + " - " + producto.getValue());
	    } 
	}
}
