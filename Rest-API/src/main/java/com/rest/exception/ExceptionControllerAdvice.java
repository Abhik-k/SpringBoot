package com.rest.exception;

import org.springframework.core.env.Environment;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

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
			return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
//	@ExceptionHandler( { Exception.class, InfyBankException.class })
//    public ResponseEntity<String> exceptionHandler(Exception exception){
//                // rest of the code                          
//    }
		
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception){
			ErrorInfo error=new ErrorInfo();
			error.setErrorCode(HttpStatus.BAD_REQUEST.value());
			error.setTimestamp(LocalDateTime.now());
			
			String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(", "));
			
			error.setErrorMessage(errorMsg);
			
			
			return new ResponseEntity<ErrorInfo>(error,HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(ConstraintViolationException.class)
		public ResponseEntity<ErrorInfo> exceptionHandler(ConstraintViolationException exception){
			ErrorInfo error=new ErrorInfo();
			error.setErrorCode(HttpStatus.BAD_REQUEST.value());
			error.setTimestamp(LocalDateTime.now());
			
			String errorMsg = exception.getConstraintViolations().stream().map(x->x.getMessage()).collect(Collectors.joining(","));
			error.setErrorMessage(errorMsg);
			
			return new ResponseEntity<ErrorInfo>(error,HttpStatus.BAD_REQUEST);
		}
			
}
