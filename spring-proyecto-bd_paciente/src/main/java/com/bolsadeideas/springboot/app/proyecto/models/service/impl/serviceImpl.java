package com.bolsadeideas.springboot.app.proyecto.models.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.proyecto.excepcion.Excepcion;
import com.bolsadeideas.springboot.app.proyecto.models.service.Iservice;
import com.bolsadeideas.springboot.app.proyecto.persistence.entities.Paciente;
import com.bolsadeideas.springboot.app.proyecto.persistence.repository.Repository;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

@Service
public class serviceImpl implements Iservice{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private Repository repository;
	
	@Override
	@Transactional(readOnly=true)
	public Page<Paciente> findAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Paciente findById(Integer id) {
	    Optional<Paciente> pacienteOpt = Optional.ofNullable(entityManager.find(Paciente.class, id));
		
	    if(pacienteOpt.isPresent())
	    	return pacienteOpt.get();
	    else throw new Excepcion("El paciente no existe en el sistema");
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Paciente findByCedula(String cedula) {
		String query = String.format("select u from Paciente u where u.cedula = '%s'", cedula);
		return (Paciente) entityManager.createQuery(query).getSingleResult();
	}
	
	
	@Override
	@Transactional
	public void agregar(Paciente paciente) {
		try {
			entityManager.persist(paciente);
		}catch(org.hibernate.exception.ConstraintViolationException e) {
			throw new Excepcion("Los datos deben ser unico");
		}
	}

	
	@Override
	@Transactional
	public Paciente editar(Paciente paciente) {
		try {
			return entityManager.merge(paciente);
		} catch (Exception e) {
		       throw new Excepcion("No se pudo actualizar los datos, intente denuevo");
		}
	}
	
	
	@Override
	@Transactional
	public void eliminar(Integer id) {
		Optional<Paciente> pacienteOpt = Optional.ofNullable(entityManager.find(Paciente.class, id));
		
		if(pacienteOpt.isPresent())
			entityManager.remove(pacienteOpt.get());
		else
			throw new Excepcion("No existe en el sistema");		
	}
}