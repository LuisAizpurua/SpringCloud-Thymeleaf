package com.bolsadeideas.springboot.app.proyecto.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Paciente;

@FeignClient(name="spring-paciente", url="localhost:8002")
public interface PacienteClient {
	
	@GetMapping
	public ResponseEntity<Page<Paciente>> findAll(Pageable pageable);
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id);
	
	@GetMapping("/cedula/{cedula}")
	public ResponseEntity<Paciente> findByCedula(@PathVariable String cedula) ;
	
	@PostMapping("/agregar")
	public ResponseEntity<Paciente> Agregar(@RequestBody Paciente paciente) ;
	
	@PostMapping("/editar")
	public ResponseEntity<Paciente> Editar(@RequestBody Paciente paciente);
		
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<Paciente> Eliminar(@PathVariable Integer id) ;
}