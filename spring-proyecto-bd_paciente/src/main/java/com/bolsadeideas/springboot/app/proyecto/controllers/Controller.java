package com.bolsadeideas.springboot.app.proyecto.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.app.proyecto.models.service.Iservice;
import com.bolsadeideas.springboot.app.proyecto.persistence.entities.Paciente;

@RestController
public class Controller {

	@Autowired
	private Iservice service;

	@GetMapping
	public ResponseEntity<Page<Paciente>> findAll(Pageable pageable) {

		Page<Paciente> page = service.findAll(pageable);

		if (page.hasContent()) {
			return ResponseEntity.ok(page);
		}

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer id) {

		Optional<Paciente> pacienteOpt = Optional.of(service.findById(id));

		if (pacienteOpt.isPresent()) {
			return ResponseEntity.ok().body(pacienteOpt.get());
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/cedula/{cedula}")
	public ResponseEntity<Paciente> findByCedula(@PathVariable String cedula) {

		Optional<Paciente> pacienteOpt = Optional.of(service.findByCedula(cedula));

		if (pacienteOpt.isPresent()) {
			return ResponseEntity.ok().body(pacienteOpt.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/agregar")
	public ResponseEntity<Paciente> Agregar(@RequestBody Paciente paciente) {
		service.agregar(paciente);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/editar")
	public ResponseEntity<Paciente> Editar(@RequestBody Paciente paciente) {
		return ResponseEntity.ok().body(service.editar(paciente));
	}

	@GetMapping("/eliminar/{id}")
	public ResponseEntity<Paciente> Eliminar(@PathVariable Integer id) {
		service.eliminar(id);
		return ResponseEntity.ok().build();
	}
}