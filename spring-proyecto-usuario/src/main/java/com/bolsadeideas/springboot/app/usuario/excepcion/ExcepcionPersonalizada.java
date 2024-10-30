package com.bolsadeideas.springboot.app.usuario.excepcion;

public class ExcepcionPersonalizada extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExcepcionPersonalizada(String message) {
		super(message);
	}
}