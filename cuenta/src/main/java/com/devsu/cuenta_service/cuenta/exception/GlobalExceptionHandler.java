package com.devsu.cuenta_service.cuenta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.devsu.cuenta_service.cuenta.DTO.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FondosNoEncontradosException.class)
	public ResponseEntity<ErrorResponseDTO> handleFondosNoEncontradosException(FondosNoEncontradosException ex) {
		ErrorResponseDTO errorResponse = ErrorResponseDTO.builder().error("Debito").mensaje(ex.getMessage()).build();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
