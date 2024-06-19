package com.rest.exception;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(InfyBankException.class)
	public ResponseEntity<String> infyBankExceptionHandler(InfyBankException exception){
		return new ResponseEntity<>(environment.getProperty(exception.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception exception){
		return new ResponseEntity<String>(environment.getProperty("General.EXCEPTION_MESSAGE"),HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler( { Exception.class, InfyBankException.class })
//    public ResponseEntity<String> exceptionHandler(Exception exception){
//                // rest of the code                          
//    }
	
	
}
