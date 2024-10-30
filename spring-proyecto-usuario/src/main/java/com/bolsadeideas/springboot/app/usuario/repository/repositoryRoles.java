package com.bolsadeideas.springboot.app.usuario.repository;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.usuario.model.entity.Roles;
import org.springframework.data.jpa.repository.Query;

public interface repositoryRoles extends CrudRepository<Roles, Integer> {

	@Query("Select u from Roles u where u.rol = ?1")
    Roles findByRol(String rol);
}