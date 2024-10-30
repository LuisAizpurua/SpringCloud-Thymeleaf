package com.bolsadeideas.springboot.app.usuario.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.app.usuario.excepcion.ExcepcionPersonalizada;

@ControllerAdvice
public class ControllerExcepcion {


	@ExceptionHandler({ExcepcionPersonalizada.class})
	public ResponseEntity<?> error(Exception e){
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("message", e.getMessage());
		map.put("Date", Calendar.DATE);
		map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		map.put("error", e.getCause());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(map);
	}
}