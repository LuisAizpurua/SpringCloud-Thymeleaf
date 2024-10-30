package com.bolsadeideas.springboot.app.usuario.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.app.usuario.model.entity.Roles;
import com.bolsadeideas.springboot.app.usuario.model.entity.Usuario;
import com.bolsadeideas.springboot.app.usuario.model.service.iservice;

@RestController
public class controller {

    @Autowired 
    private iservice service;
    
    
    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody Usuario usuario) {
    	service.save(usuario);
    	return ResponseEntity.ok(Collections.singletonMap("message", "Usuario creado con exito"));
    }
    
    
    @GetMapping("/cedula/{cedula}")
    public Usuario findByIdentificacion(@PathVariable String cedula) {
    	return service.findByIdentificacion(cedula);
    }    
    
    
	@GetMapping("/password/{password}")
	public Usuario findByPassword(@PathVariable(name = "password") String password) {
		return service.findByPassword(password);
	}
	
	@PostMapping("/editar")
	public ResponseEntity<?> editar(@RequestBody Usuario usuario) {
		service.editar(usuario);
		return ResponseEntity.ok(Collections.singletonMap("message", "Usuario actualizado con exito"));
	}		
	
	@GetMapping("/rol/{rol}")
	public Roles findByRol(@PathVariable String rol) {
		return service.findByRol(rol);
	}
}