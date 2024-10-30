package com.bolsadeideas.springboot.app.proyecto.models.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.proyecto.persistence.entities.Medico;

public interface Iservice {

    Page<Medico> findAll(Pageable pageable);
    
    Medico findById(Integer id);
    
    Medico findByCodigo(String cod);
    
    Medico findByCedula(String cedula);
    
    void agregar(Medico medico);	
	
    Medico editar(Medico medico) ;
	
    void eliminar(Integer id) ;
	
}