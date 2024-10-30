package com.bolsadeideas.springboot.app.proyecto.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Medico;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServiceMedico;
import com.bolsadeideas.springboot.app.proyecto.cliente.MedicoClient;

@Service
public class serviceMedicoImpl implements IServiceMedico{

    @Autowired
    private MedicoClient service;
	
    @Override
    public ResponseEntity<Page<Medico>> findAll(Pageable pageable) {
    	return service.findAll(pageable);
    }
    
	@Override
	public ResponseEntity<Medico> findById(Integer id) {
		return service.findById(id);
	}

	@Override
	public ResponseEntity<Medico> findByCodigo(String cod) {
		return service.findByCodigo(cod);
	}

	@Override
	public ResponseEntity<Medico> findByCedula(String cedula) {
		return service.findByCedula(cedula);
	}

	@Override
	public void agregar(Medico medico) {
	      service.agregar(medico);
	}

	@Override
	public ResponseEntity<Medico> editar(Medico medico) {
	    return service.editar(medico);
	}

	@Override
	public void eliminar(Integer id) {
		service.eliminar(id);
	}

}