package com.rest.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ErrorInfo {
	
	private String errorMessage;
	private Integer errorCode;
	private LocalDateTime timestamp;
}
