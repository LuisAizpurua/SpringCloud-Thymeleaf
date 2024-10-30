package com.bolsadeideas.springboot.app.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.app.proyecto.models.service.Iservice;
import com.bolsadeideas.springboot.app.proyecto.persistence.entities.Medico;

@RestController
public class Controller {

	@Autowired
	private Iservice service;

	@GetMapping
	public ResponseEntity<Page<Medico>> findAll(Pageable pageable) {

		Page<Medico> page = service.findAll(pageable);

		if (page.hasContent()) {
			return ResponseEntity.ok(page);
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medico> findById(@PathVariable Integer id) {

		Medico medico = service.findById(id);
		if (medico == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(medico);
	}

	@GetMapping("/codigo/{cod}")
	public ResponseEntity<Medico> findByCodigo(@PathVariable String cod) {
		Medico medico = service.findByCodigo(cod);

		if (medico == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(medico);
	}

	@GetMapping("/cedula/{cedula}")
	public ResponseEntity<Medico> findByCedula(@PathVariable String cedula) {

		Medico medico = service.findByCedula(cedula);

		if (medico == null)
			ResponseEntity.notFound().build();

		return ResponseEntity.ok(medico);
	}

	@PostMapping("/agregar")
	public void agregar(@RequestBody Medico medico) {
		service.agregar(medico);
	}

	@PostMapping("/editar")
	public ResponseEntity<Medico> editar(@RequestBody Medico medico) {
		Medico medicoResult = service.editar(medico);
		if (medicoResult == null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok().body(medicoResult);
	}

	@GetMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}
}