package com.bolsadeideas.springboot.app.usuario.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Roles implements Serializable{

	private static final long serialVersionUID = -206955229117283204L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(insertable=false,updatable=false)
	private String rol;
	
	public Roles(Integer id, String rol) {
		this.id = id;
		this.rol = rol;
	}
	
	public Roles() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "id=" + id + ", rol=" + rol;
	}
}