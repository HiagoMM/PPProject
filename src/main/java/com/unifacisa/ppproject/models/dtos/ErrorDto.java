package com.unifacisa.ppproject.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorDto {
	
	private String message;
	private int code;
	
}
