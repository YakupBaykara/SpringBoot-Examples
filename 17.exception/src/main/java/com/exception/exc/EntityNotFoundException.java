package com.exception.exc;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String param) {
		super(param);
	}
}
