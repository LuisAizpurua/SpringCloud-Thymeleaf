package com.bolsadeideas.springboot.app.proyecto.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsadeideas.springboot.app.proyecto.persistence.entities.Medico;

public interface Repository extends JpaRepository<Medico,Integer>{	
}