package com.devsu.cuenta_service.cuenta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	  @ExceptionHandler(FondosNoEncontradosException.class)
	    public ResponseEntity<String> handleResourceNotFoundException(FondosNoEncontradosException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	
}
