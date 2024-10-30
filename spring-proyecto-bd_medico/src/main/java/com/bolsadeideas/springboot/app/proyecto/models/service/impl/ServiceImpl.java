package com.bolsadeideas.springboot.app.proyecto.models.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.proyecto.excepcion.ExcepcionPersonalizada;
import com.bolsadeideas.springboot.app.proyecto.models.service.Iservice;
import com.bolsadeideas.springboot.app.proyecto.persistence.entities.Medico;
import com.bolsadeideas.springboot.app.proyecto.persistence.repository.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ServiceImpl implements Iservice {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private Repository repository;

	private final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
	
	@Override
	@Transactional(readOnly = true)
	public Page<Medico> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Medico findById(Integer id) {

		Optional<Medico> medicoOpt = Optional.ofNullable(manager.find(Medico.class, id));

		if (medicoOpt.isPresent())
			return medicoOpt.orElseThrow(() -> new ExcepcionPersonalizada("No existe en el sistema"));

		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Medico findByCodigo(String cod) {
		String query = String.format("Select u from Medico u where u.codigo = '%s'", cod);
		
		Optional<Medico> medicoOpt = Optional.of(manager.createQuery(query, Medico.class).getSingleResult());
		
		if(medicoOpt.isPresent())
			return medicoOpt.orElseThrow(() -> new ExcepcionPersonalizada("No existe en el sistema"));
		
		return null;
	}

	@Override
	@Transactional
	public void agregar(Medico medico) {
		try {
			manager.persist(medico);
		} catch (Exception e) {
			throw new ExcepcionPersonalizada("No se agrego el medico al sistema, vuelva a intentarlo");
		}
	}

	@Override
	@Transactional
	public Medico editar(Medico medico) {

		Optional<Medico> medicoOpt = Optional.of(manager.merge(medico));

		if (medicoOpt.isPresent()) 
			return medicoOpt.orElseThrow(() -> new ExcepcionPersonalizada("No se pudo actualizar los datos, vuelva a intentarlo"));
		
		return null;
	}

	
	@Override
	@Transactional(readOnly = true)
	public Medico findByCedula(String cedula) {

		String query = String.format("Select u from Medico u where u.cedula = '%s'", cedula);
		Optional<Medico> medicoOpt = Optional.of(manager.createQuery(query, Medico.class).getSingleResult());
		return medicoOpt.orElseThrow(() -> new ExcepcionPersonalizada("No existe en el sistema"));
	}
	
	
	@Override
	@Transactional
	public void eliminar(Integer id) {
		
		Optional<Medico> medicoOpt = Optional.ofNullable(manager.find(Medico.class, id));
		
		medicoOpt.ifPresentOrElse((medico) -> manager.remove(medico),
				  () -> runnable(id).run()
				);
	}

	private Runnable runnable(Integer id) {
		return new Runnable(){
			@Override
			public void run() {
				 logger.error("Error al eliminar el recurso con ID " + id);
			}	
	};
	}
}