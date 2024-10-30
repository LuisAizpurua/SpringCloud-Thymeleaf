package com.bolsadeideas.springboot.app.proyecto.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntercepcionAop {

	private final Logger logger = LoggerFactory.getLogger(IntercepcionAop.class);
	
	@After("execution(* com.bolsadeideas.springboot.app.proyecto.controllers.Controller.**(..))")
	public void beforeMetodo(JoinPoint join) {
		
		String args = ""; 
		for(Object n : join.getArgs()) {
			args += n.toString().concat(", ");
		}
		
		String msg = String.format("El metodo %s con sus parametros: %s", join.getSignature().getName(),args);
		logger.info(msg);
		
	}
}
