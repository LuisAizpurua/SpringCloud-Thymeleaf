package com.bolsadeideas.springboot.app.proyecto.aspecto;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Aspect
@Component
public class AspectHandler {

	static String rol;
	static public Logger logger = LoggerFactory.getLogger(AspectHandler.class);
	
	@PostConstruct
	public void setRol() {
		rol = "paciente";
	}
	
	@Around("execution(* com.bolsadeideas.springboot.app.proyecto.cliente.ClientesRepository.*(..))")
	public Object around(ProceedingJoinPoint join) throws Throwable {
		
		if(join.getSignature().getName() == "findAll") {
			return join;
		}
		
		Object[] args = join.getArgs();
		
	    StringBuilder builder = new StringBuilder("/");
	    builder.append(rol);
	    builder.append(args[0].toString());
	    
	    args[0] = builder.toString();
	    
	    Object result = join.proceed(args);
	    
	    System.out.print("sss");
	    logger.info("Around: El metodo " + join.getSignature().getName() + " con el parametro " + result);
	    return result;
	}
}