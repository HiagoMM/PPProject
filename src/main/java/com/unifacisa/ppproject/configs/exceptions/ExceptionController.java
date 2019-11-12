package com.unifacisa.ppproject.configs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.unifacisa.ppproject.exceptions.BadRequestException;
import com.unifacisa.ppproject.models.dtos.ErrorDto;

@ControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorDto> badRequest(BadRequestException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
		
	}
}
