package com.example.demo.common;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class iAccessExamExceptionHandler {

	@ExceptionHandler(value = {iAccessExamException.class})
	public ResponseEntity<Object> handleApiRequestException(iAccessExamException e) {
		
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		
		iAccessExamError error = new iAccessExamError(
				e.getMessage(),
				400,
				HttpStatus.BAD_REQUEST, 
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		
		return new ResponseEntity<>(error, badRequest);
	}
	
	@ExceptionHandler(value = {iAccessExamFilterRequestNotFoundException.class})
	public ResponseEntity<Object> handleApiRequestException(iAccessExamFilterRequestNotFoundException e) {
		
		HttpStatus badRequest = HttpStatus.NOT_FOUND;
		
		iAccessExamError error = new iAccessExamError(
				e.getMessage(),
				404,
				HttpStatus.NOT_FOUND, 
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		
		return new ResponseEntity<>(error, badRequest);
	}
	
	@ExceptionHandler(value = {iAccessExamInvalidArgumentException.class})
	public ResponseEntity<Object> handleApiRequestException(iAccessExamInvalidArgumentException e) {
		
		HttpStatus badRequest = HttpStatus.UNPROCESSABLE_ENTITY;
		
		iAccessExamError error = new iAccessExamError(
				e.getMessage(),
				422,
				HttpStatus.UNPROCESSABLE_ENTITY, 
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		
		return new ResponseEntity<>(error, badRequest);
	}
	
}
