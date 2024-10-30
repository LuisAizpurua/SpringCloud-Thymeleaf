package com.bolsadeideas.springboot.app.proyecto.models.entities;

public class Usuario {
	private Integer id;
	
	private String name;
	
	private String lastname;
	
	private String identificacion;
	
	private String username;
	
	private String password;

	private Roles roles;

	private ControlAcceso controlAcceso;
	
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
		return "id=" + id + ", name=" + name + ", lastname=" + lastname + ", identificacion=" + identificacion
				+ ", username=" + username + ", password=" + password + ", roles=" + roles.getRol() ;
	}
	
	
}