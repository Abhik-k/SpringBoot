package com.rest.exception;

import org.springframework.core.env.Environment;

import java.time.LocalDateTime;

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
	public ResponseEntity<ErrorInfo> infyBankExceptionHandler(InfyBankException exception){
		ErrorInfo error=new ErrorInfo();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(environment.getProperty(exception.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception){
			ErrorInfo error=new ErrorInfo();
			error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
			error.setTimestamp(LocalDateTime.now());
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
	
//	@ExceptionHandler( { Exception.class, InfyBankException.class })
//    public ResponseEntity<String> exceptionHandler(Exception exception){
//                // rest of the code                          
//    }
	
	
}
