package com.bolsadeideas.springboot.app.usuario.model.entity;

import java.io.Serializable;
import com.bolsadeideas.springboot.app.usuario.excepcion.nombreExcepcion;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Column;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 3200923245823356065L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@nombreExcepcion
	@Column(updatable=false)
	private String name;
	
	@nombreExcepcion
	@Column(updatable=false)
	private String lastname;
	
	@Column(unique=true, updatable=false, length=25)
	private String identificacion;
	
	@NotEmpty
	@Column(unique=true, updatable=true, length=15)
	private String username;
	
	@NotBlank
	@Column(unique=true, updatable=true, length=15)
	private String password;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rol")
	private Roles roles;
	
	@Embedded
	private ControlAcceso controlAcceso;
	
	@PrePersist
	private void pre() {
		this.controlAcceso = new ControlAcceso();
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	public ControlAcceso getControlAcceso() {
		return controlAcceso;
	}

	public void setControlAcceso(ControlAcceso controlAcceso) {
		this.controlAcceso = controlAcceso;
	}

	@Override
	public String toString() {
		return  "id: " + id +
				"\nname: " + name +
				"\nlastname: " + lastname +
				"\nidentificacion: " + identificacion +
				"\nusername: " + username +
				"\npassword: " + password +
				"\nControlAcceso: " + controlAcceso;
	}
}