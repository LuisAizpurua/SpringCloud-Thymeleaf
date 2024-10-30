package com.bolsadeideas.springboot.app.proyecto.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.proyecto.cliente.PacienteClient;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Paciente;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServicePaciente;

@Service
public class ServicePacienteImpl implements IServicePaciente {

	@Autowired
	private PacienteClient pacienteCliente;

	@Override
	public ResponseEntity<Page<Paciente>> findAll(Pageable pageable) {
		return pacienteCliente.findAll(pageable);
	}

	@Override
	public ResponseEntity<Paciente> findById(Integer id) {
		return pacienteCliente.findById(id);
	}

	@Override
	public ResponseEntity<Paciente> findByCedula(String cedula) {
		return pacienteCliente.findByCedula(cedula);
	}

	@Override
	public ResponseEntity<Paciente> agregar(Paciente paciente) {
		return pacienteCliente.Agregar(paciente);
	}

	@Override
	public ResponseEntity<Paciente> editar(Paciente paciente) {
		return pacienteCliente.Editar(paciente);
	}

	@Override
	public ResponseEntity<Paciente> eliminar(Integer id) {
		return pacienteCliente.Eliminar(id);
	}
	

}