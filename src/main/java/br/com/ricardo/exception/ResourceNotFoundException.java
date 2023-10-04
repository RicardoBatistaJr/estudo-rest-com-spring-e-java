package br.com.ricardo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private String message = "Resource not founded!";
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
	}

	public String getMessage() {
		return message;
	}
}
