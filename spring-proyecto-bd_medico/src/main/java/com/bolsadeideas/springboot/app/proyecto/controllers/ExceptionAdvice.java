package com.bolsadeideas.springboot.app.proyecto.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.app.proyecto.excepcion.ExcepcionPersonalizada;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionAdvice {

	private final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
    Map<String, Object> map;
	
	ObjectMapper mapper;
	
    
	@PostConstruct
	public void constructor() {
		this.map = new HashMap<String, Object>();
		this.mapper = new ObjectMapper();
	}

	@ExceptionHandler({ ExcepcionPersonalizada.class, NullPointerException.class })
	public void error(Exception e, HttpServletResponse response, HttpServletRequest request) {

		logger.error(String.format("%s => %s", request.getMethod(), e.getMessage()));

		responseRespuesta(response, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e.getLocalizedMessage());
	}

	
	@ExceptionHandler({ org.hibernate.exception.ConstraintViolationException.class})
	public void ErrorConstraint(Exception e, HttpServletResponse response, HttpServletRequest request) {
		
		logger.error(String.format("%s => %s", request.getMethod(), e.getMessage()));

		responseRespuesta(response, HttpStatus.INTERNAL_SERVER_ERROR, "Los datos deben ser unico", e.getLocalizedMessage());
	}
	
	
	public void responseRespuesta(HttpServletResponse response, HttpStatus status, String message, String error) {
		
		map.put("message", message);
		map.put("error", error);
		map.put("Date", LocalDateTime.now().toString().replace("T", " "));
		map.put("status", status.value());
		response.setContentType("application/json");
		response.setStatus(status.value());
		try {
			response.getWriter().write(mapper.writeValueAsString(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}