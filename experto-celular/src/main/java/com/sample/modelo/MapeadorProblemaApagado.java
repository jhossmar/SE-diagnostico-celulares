package com.sample.modelo;

import java.util.HashMap;
import java.util.Map;

public class MapeadorProblemaApagado {
	private Map mapa;
	private boolean habilitado = false;
	
	public MapeadorProblemaApagado() {
		this.mapa = new HashMap();
		this.agregarProblemas();
	}
	
	public void agregarProblemas() {
		this.mapa.put("El telefono se apaga solo", new Problema(TipoEstado.TELEFONO_APAGA_SOLO));
		this.mapa.put("Se Reinicia al realizar una llamada", new Problema(TipoEstado.SE_REINICIA_AL_LLAMAR));
		this.mapa.put("Amplificador Potencia", new Problema(TipoEstado.AMPLIFICADOR_POTENCIA));
		this.mapa.put("El Amplificador de Potencia esta Reemplazado", new Problema(TipoEstado.REEMPLAZADO_AMPLIFICADOR_P));
		this.mapa.put("Se cuelga cuando se entra en un menu especial", new Problema(TipoEstado.SE_CUELGA_EN_MENU_ESPECIAL));
		this.mapa.put("Se Reinicia solo", new Problema(TipoEstado.SE_REINICIA));
		this.mapa.put("Software Desactualizado", new Problema(TipoEstado.SOFTWARE_DESACTUALIZADO));
		this.mapa.put("El software esta actualizado", new Problema(TipoEstado.SOFTWARE_ESTA_ACTUALIZADO));
	}
	
	public Problema obtenerProblema(String llave) {
		if(!habilitado ) {
			habilitado = true;
			return (Problema) this.mapa.get(llave);
		} else {
			return (Problema) this.mapa.get(llave);
		}
	}
}
