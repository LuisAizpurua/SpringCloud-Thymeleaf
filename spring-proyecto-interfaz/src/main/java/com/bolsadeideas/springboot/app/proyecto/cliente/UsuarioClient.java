package com.bolsadeideas.springboot.app.proyecto.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Usuario;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Roles;

@FeignClient(name ="servicio-usuario")
public interface UsuarioClient {

	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(Usuario usuario);

	@GetMapping("/cedula/{cedula}")
	public Usuario findByIdentificacion(@PathVariable String cedula);

	@GetMapping("/password/{password}")
	public Usuario findByPassword(@PathVariable String password);

	@PostMapping("/editar")
	public ResponseEntity<?> editar(Usuario usuario);
	
	@GetMapping("/rol/{rol}")
	public Roles findByRol(@PathVariable String rol);
}