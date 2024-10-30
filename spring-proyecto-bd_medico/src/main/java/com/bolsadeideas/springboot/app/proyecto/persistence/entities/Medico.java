package com.bolsadeideas.springboot.app.proyecto.persistence.entities;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name="medicos")
public class Medico implements Serializable{

	private static final long serialVersionUID = 2970882604847555118L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(unique=true, updatable=false, length=5)
	private String codigo;
	
	@Column(nullable=false, unique=true,updatable=false, length=30)
	private String cedula;
	
	@NotBlank
	@Column(length=25,updatable=false)
	private String nombre;
	
	@NotBlank
	@Column(updatable=false, length=25)
	private String apellido;
	
	@Column(length=30)
	private String direccion;
	
	@Column(length=8)
	private String telefono;
	
	@NotEmpty
	@Column(updatable=true,length=25)
	private String especialidad;
	
	@NotNull
	private Integer pacientes_mes;
	
	@NotNull
	private Integer pacientes_anual;
	
	private String foto;
	
	@PrePersist
	public void pre() {
		UUID cod = UUID.randomUUID();
		this.codigo = cod.toString().substring(0,5);
		
	}
	
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
		return "id=" + id 
				+ ", codigo=" + codigo 
				+ ", cedula=" + cedula 
				+ ", nombre=" + nombre 
				+ ", apellido=" + apellido 
				+ ", direccion=" + direccion 
				+ ", telefono=" + telefono 
				+ ", especialidad=" + especialidad
				+ ", pacientes_mes=" + pacientes_mes 
				+ ", pacientes_anual=" + pacientes_anual
				+ ", foto= " + foto;
	}
}