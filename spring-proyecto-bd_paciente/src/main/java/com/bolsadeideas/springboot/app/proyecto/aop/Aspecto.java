package com.bolsadeideas.springboot.app.proyecto.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspecto {

	private final Logger logger = LoggerFactory.getLogger(Aspecto.class);
	
	@Before("execution(* com.bolsadeideas.springboot.app.proyecto.controllers.Controller.**(..))")
	public void before(JoinPoint point) {
		
		String metodo = point.getSignature().getName();
		
		String msg = String.format("before: se ejecuta el metodo %s", metodo);
		logger.info(msg);
	}
}