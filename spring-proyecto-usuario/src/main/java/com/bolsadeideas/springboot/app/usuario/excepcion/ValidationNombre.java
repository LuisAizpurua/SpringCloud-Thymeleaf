package com.bolsadeideas.springboot.app.usuario.excepcion;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ValidationNombre implements ConstraintValidator<nombreExcepcion,String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return (value.trim() != null && value.length()<=25);
	}

}
