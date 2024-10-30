package com.bolsadeideas.springboot.app.proyecto.models.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.proyecto.persistence.entities.Paciente;

public interface Iservice {
	
	Page<Paciente>  findAll(Pageable pageable);
	
    Paciente findById(Integer id);
    
    Paciente findByCedula(String cedula);
    
    void agregar(Paciente paciente);	
	
    Paciente editar(Paciente paciente) ;
	
    void eliminar(Integer id) ;
}	