package com.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exception.exc.EntityNotFoundException;

// This class will run all exceptions occured in RestController endpoints. 
@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler({EntityNotFoundException.class})
	public String entityNotFound() {
		return "No record found!";
	}
	
	@ExceptionHandler({IllegalArgumentException.class})
	public String iaException() {
		return "Wrong argument!";
	}
}
