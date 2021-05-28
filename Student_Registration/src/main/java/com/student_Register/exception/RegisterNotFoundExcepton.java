package com.student_Register.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegisterNotFoundExcepton extends RuntimeException {
	
	private static final Long serialVersionUID = 1L;
	
	public RegisterNotFoundExcepton(String message ) {
		
		super(message);
		 
	}

}
