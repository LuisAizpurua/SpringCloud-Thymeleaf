package com.bolsadeideas.springboot.app.usuario.model.service;

import org.slf4j.LoggerFactory;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.usuario.excepcion.ExcepcionPersonalizada;
import com.bolsadeideas.springboot.app.usuario.model.entity.Roles;
import com.bolsadeideas.springboot.app.usuario.model.entity.Usuario;
import com.bolsadeideas.springboot.app.usuario.repository.repositorio;
import com.bolsadeideas.springboot.app.usuario.repository.repositoryRoles;

@Service
public class serviceImpl implements iservice{

	@Autowired
	private repositorio resp_usuario;
	
	@Autowired
	private repositoryRoles resp_roles;
	
	static final Logger logger = LoggerFactory.getLogger(serviceImpl.class);
	
	@Override
	@Transactional
	public void save(Usuario usuario) {

		try {
			if (usuario.getRoles().getId() == 1)
				usuario.setRoles(resp_roles.findById(1).get());
			else
				usuario.setRoles(resp_roles.findById(2).get());

			resp_usuario.save(usuario);
		} catch (Exception e) {
			throw new ExcepcionPersonalizada("No se pudo guardar el usuario, vuelva a intentarlo");
		}
	}
	

	@Override
	@Transactional(readOnly=true)
	public Usuario findByIdentificacion(String cedula) {
		
		Optional<Usuario> usuarioOpt = resp_usuario.findByIdentificacion(cedula);
		
		if(usuarioOpt.isPresent()) {
			return usuarioOpt.get();
		}else {
			throw new ExcepcionPersonalizada("No existe usuario en el sistema");
		}
	}

	
	@Override
	@Transactional(readOnly=true)
	public Usuario findByPassword(String password) {
		Optional<Usuario> usuarioOpt = resp_usuario.findByPassword(password);
        if(usuarioOpt.isPresent()) {
        	return usuarioOpt.get();
        }else {
        	throw new ExcepcionPersonalizada("Password o username incorrecto");
        }
	}



	@Override
	public void editar(Usuario usuario) {
		try {
			Usuario usu = usuario;
			resp_usuario.save(usu);
		}catch(Exception e) {
			throw new ExcepcionPersonalizada("No se pudo actualizar los datos, intentelo denuevo");
		}
	}


	@Override
	public Roles findByRol(String rol) {
		return resp_roles.findByRol(rol);
	}		
}