package com.bolsadeideas.springboot.app.usuario.excepcion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Constraint(validatedBy= ValidationNombre.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD ,ElementType.FIELD})
public @interface nombreExcepcion {
	
	String message() default "name o lastname es incorrecto!";

	Class<?>[] groups() default { };

	Class<?>[] payload() default { };
}
