package com.bolsadeideas.springboot.app.proyecto.dto;

import jakarta.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Medico;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Paciente;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServiceMedico;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServicePaciente;

@Service
public class FindByRol {

	@Autowired
	private IServicePaciente servicePaciente;
	
	@Autowired
	private IServiceMedico serviceMedico;
	
	
	public FindByRol() {}
	
	public Page<?> Roles(@Null String rol) {
		if (rol == null)
			return null;

		boolean access = rol.equals("paciente") ? true : false;

		if (access)
			return servicePaciente.findAll(Pageable.ofSize(5).first()).getBody();
		else
			return serviceMedico.findAll(Pageable.ofSize(5).first()).getBody();
	}
	
	public Medico RolMedico(int id) {
		return serviceMedico.findById(id).getBody();
	}
	
	
	public Paciente RolPaciente(int id) {
		return servicePaciente.findById(id).getBody();
	}
}
