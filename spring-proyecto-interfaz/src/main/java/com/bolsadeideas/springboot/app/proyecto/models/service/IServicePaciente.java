package com.bolsadeideas.springboot.app.proyecto.models.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Paciente;

public interface IServicePaciente {

	ResponseEntity<Page<Paciente>> findAll(Pageable pageable);
    
	ResponseEntity<Paciente> findById(Integer id);
    
	ResponseEntity<Paciente> findByCedula(String cedula);
    
	ResponseEntity<Paciente> agregar(Paciente paciente);	
	
	ResponseEntity<Paciente> editar(Paciente paciente) ;
	
	ResponseEntity<Paciente> eliminar(Integer id) ;
}