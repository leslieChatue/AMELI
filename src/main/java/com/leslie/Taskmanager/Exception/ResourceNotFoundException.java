package com.leslie.Taskmanager.Exception;

public class ResourceNotFoundException extends RuntimeException{//Avec runtimeException on a plus besoin de faire des try catch

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
