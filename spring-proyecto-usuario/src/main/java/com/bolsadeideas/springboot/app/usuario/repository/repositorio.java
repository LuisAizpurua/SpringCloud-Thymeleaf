package com.bolsadeideas.springboot.app.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.usuario.model.entity.Usuario;

public interface repositorio extends CrudRepository<Usuario,Integer>{

	@Query("select u from Usuario u join fetch u.roles where u.password = ?1")
	public Optional<Usuario> findByPassword(String password); 
	
	@Query("select u from Usuario u join fetch u.roles where u.identificacion = ?1")
	public Optional<Usuario> findByIdentificacion(String ide); 
}