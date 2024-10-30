package com.bolsadeideas.springboot.app.proyecto.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsadeideas.springboot.app.proyecto.persistence.entities.Paciente;

public interface Repository extends JpaRepository<Paciente,Integer>{

}