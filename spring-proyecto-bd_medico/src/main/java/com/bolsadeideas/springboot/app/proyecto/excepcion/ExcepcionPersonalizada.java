package com.bolsadeideas.springboot.app.proyecto.excepcion;

public class ExcepcionPersonalizada extends RuntimeException{

	private static final long serialVersionUID = 4L;

	public ExcepcionPersonalizada(String message) {
		super(message);
	}
}
