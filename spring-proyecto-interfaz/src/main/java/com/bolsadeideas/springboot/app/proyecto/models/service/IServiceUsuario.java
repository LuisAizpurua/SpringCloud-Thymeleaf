package com.bolsadeideas.springboot.app.proyecto.models.service;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Roles;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Usuario;

public interface IServiceUsuario {

	public void save(Usuario usuario);
	
	public Usuario findByIdentificacion(String ide);	
	
	public Usuario findByPassword(String password);
	
	public void editar(Usuario usuario);
	
	public Roles findByRol(String rol);
}