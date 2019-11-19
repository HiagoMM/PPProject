package com.unifacisa.ppproject.configs.exceptions;


import java.util.Iterator;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.unifacisa.ppproject.exceptions.BadRequestException;
import com.unifacisa.ppproject.models.dtos.ErrorDto;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 Iterator<FieldError> iterator = ex.getBindingResult().getFieldErrors().iterator();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(iterator.next().getDefaultMessage(), HttpStatus.BAD_REQUEST.value()));
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorDto> badRequest(BadRequestException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDto> badRequest(ConstraintViolationException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto("Elemento já existe", HttpStatus.BAD_REQUEST.value()));
	}
	
}
