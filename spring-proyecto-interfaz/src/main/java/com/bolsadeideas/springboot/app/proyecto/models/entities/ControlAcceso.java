package com.bolsadeideas.springboot.app.proyecto.models.entities;

import java.time.LocalDateTime;

public class ControlAcceso {

	private LocalDateTime entrada;
	
	private LocalDateTime actualizacion;

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getActualizacion() {
		return actualizacion;
	}

	public void setActualizacion(LocalDateTime actualizacion) {
		this.actualizacion = actualizacion;
	}
	
	
}