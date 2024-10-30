package com.bolsadeideas.springboot.app.usuario.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Embeddable
public class ControlAcceso {

	private LocalDateTime entrada;
	
	private LocalDateTime actualizacion;

    public ControlAcceso() {}
	
	@PrePersist
	private void pre() {
		this.entrada = LocalDateTime.now();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.actualizacion = LocalDateTime.now();
	}
    
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

	@Override
	public String toString() {
		return "entrada= " + entrada 
			   + ", actualizacion= " + actualizacion;
	}	
}