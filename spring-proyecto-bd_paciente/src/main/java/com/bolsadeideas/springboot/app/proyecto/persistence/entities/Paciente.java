package com.bolsadeideas.springboot.app.proyecto.persistence.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
@Entity 
@Table(name="pacientes")
public class Paciente implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(updatable=false, unique=true)
	private String cedula;
	
	@NotBlank
	@Column(updatable=false, length=25)
	private String nombre;
	
	@NotBlank
	@Column(updatable=false, length=25)
	private String apellido;
	
	@Column(length=35)
	private String direccion;
	
	@NotBlank
	@Column(length=8)
	private String telefono;
	
	@Column(updatable=false)
	@NotNull
	private String provincia;
	
	@NotNull
	@Column(updatable=false)
	private Integer edad;
	
	@NotBlank
	@Column(length=1, updatable=false)
	private String sexo;
	
	private String foto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
				+ ", cedula=" + cedula 
				+ ", nombre=" + nombre 
				+ ", apellido=" + apellido
				+ ", direccion=" + direccion 
				+ ", telefono=" + telefono 
				+ ", provincia=" + provincia 
				+ ", edad=" + edad
				+ ", sexo=" + sexo
				+ ", foto=" + foto;
	}

	private static final long serialVersionUID = 6693325840295158710L;
}