package com.bolsadeideas.springboot.app.proyecto.models.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Medico;
public interface IServiceMedico {

	
	ResponseEntity<Page<Medico>> findAll(Pageable pageable);

	ResponseEntity<Medico> findById(Integer id);
    
	ResponseEntity<Medico> findByCodigo(String cod);
    
	ResponseEntity<Medico> findByCedula(String cedula);
    
    void agregar(Medico medico);	
	
    ResponseEntity<Medico> editar(Medico medico) ;
	
    void eliminar(Integer id) ;
}