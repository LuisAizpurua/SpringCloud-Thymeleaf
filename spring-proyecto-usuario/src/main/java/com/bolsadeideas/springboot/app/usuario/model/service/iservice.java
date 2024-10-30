package com.bolsadeideas.springboot.app.usuario.model.service;

import com.bolsadeideas.springboot.app.usuario.model.entity.Roles;
import com.bolsadeideas.springboot.app.usuario.model.entity.Usuario;

public interface iservice{

	public void save(Usuario usuario);
	
	public Usuario findByIdentificacion(String ide);	
	
	public Usuario findByPassword(String password);
	
	public void editar(Usuario usuario);
	
	public Roles findByRol(String rol);
	
}