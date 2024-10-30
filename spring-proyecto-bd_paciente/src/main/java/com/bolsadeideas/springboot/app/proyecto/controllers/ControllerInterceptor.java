package com.bolsadeideas.springboot.app.proyecto.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.app.proyecto.excepcion.Excepcion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ControllerInterceptor {

	Map<String,Object> map;
	
	ObjectMapper mapper;
	
	@Autowired
	private Environment env;
	
	@PostConstruct
	public void constructor() {
		this.map = new HashMap<>();
		this.mapper = new ObjectMapper();
	}
	
	@ExceptionHandler({Excepcion.class})
	public void error(Exception e, HttpServletResponse response, HttpServletRequest request) {
		
		map.put("message", e.getMessage());
		map.put("Date", LocalDateTime.now().toString().replace("T", " "));
		getResponse(response, HttpStatus.INTERNAL_SERVER_ERROR,request, map);
	}	
	
	@ExceptionHandler({org.springframework.dao.DataIntegrityViolationException.class})
	public void errorTelefono(Exception e, HttpServletResponse response, HttpServletRequest request) {
		
		map.put("message", env.getProperty("message.paciente.telefono"));
		map.put("Date", LocalDateTime.now().toString().replace("T", " "));
		getResponse(response, HttpStatus.INTERNAL_SERVER_ERROR,request, map);
	}	
	
	
	public void getResponse(HttpServletResponse response,HttpStatus statu,HttpServletRequest request, Map<String,Object> map) {
		try {
			map.put("status", statu.value());
			
			response.setContentType("application/json");
			response.setStatus(statu.value());
			response.getWriter().write(mapper.writeValueAsString(map));
			response.setHeader("Method", request.getMethod().toString());
		
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
	}
	
	
}