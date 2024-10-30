package com.bolsadeideas.springboot.app.proyecto.models.service.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Roles;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Usuario;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServiceUsuario;

@Service
public class serviceUsuarioImpl implements IServiceUsuario{

	@Autowired
	private RestTemplate rest;
	
	@Override
	public void save(Usuario usuario) {
		rest.postForObject("http://servicio-usuario/agregar", usuario, Usuario.class);
	}

	@Override
	public Usuario findByIdentificacion(String ide) {
		return rest.getForObject("http://servicio-usuario/cedula/{cedula}", Usuario.class, Collections.singletonMap("cedula", ide));
	}

	@Override
	public Usuario findByPassword(String password) {
		return rest.getForObject("http://servicio-usuario/password/{password}", Usuario.class, Collections.singletonMap("password", password));
	}

	@Override
	public void editar(Usuario usuario) {
		rest.postForObject("http://servicio-usuario/editar", usuario, Usuario.class);
	}

	@Override
	public Roles findByRol(String rol) {
		return rest.getForObject("http://servicio-usuario/rol/{rol}", Roles.class, Collections.singletonMap("rol",rol));
	}
}