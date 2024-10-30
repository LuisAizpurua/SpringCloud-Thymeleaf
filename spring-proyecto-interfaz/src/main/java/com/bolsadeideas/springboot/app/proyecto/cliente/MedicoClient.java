package com.bolsadeideas.springboot.app.proyecto.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Medico;

@FeignClient(name="spring-medico", url="localhost:8004")
public interface MedicoClient {
	
	@GetMapping
	public ResponseEntity<Page<Medico>> findAll(Pageable pageable);
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> findById(@PathVariable Integer id);

	@GetMapping("/codigo/{cod}")
	public ResponseEntity<Medico> findByCodigo(@PathVariable String cod);
	
	@GetMapping("/cedula/{cedula}")
	public ResponseEntity<Medico> findByCedula(@PathVariable String cedula) ;
	
	@PostMapping("/agregar")
	public void agregar(@RequestBody Medico medico) ;

	@PostMapping("/editar")
	public ResponseEntity<Medico> editar(@RequestBody Medico medico) ;

	@GetMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id);
}
