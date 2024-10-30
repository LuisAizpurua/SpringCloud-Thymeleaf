package com.bolsadeideas.springboot.app.proyecto.models.entities;

public class Medico {

	private Integer id;
	private String codigo;
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String especialidad;
	private Integer pacientes_mes;
	private Integer pacientes_anual;
	private String foto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public Integer getPacientes_mes() {
		return pacientes_mes;
	}
	public void setPacientes_mes(Integer pacientes_mes) {
		this.pacientes_mes = pacientes_mes;
	}
	public Integer getPacientes_anual() {
		return pacientes_anual;
	}
	public void setPacientes_anual(Integer pacientes_anual) {
		this.pacientes_anual = pacientes_anual;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido="
				+ apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", especialidad=" + especialidad
				+ ", pacientes_mes=" + pacientes_mes + ", pacientes_anual=" + pacientes_anual + ", foto=" + foto;
	}
	
	
}