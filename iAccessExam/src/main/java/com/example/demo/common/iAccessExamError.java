package com.example.demo.common;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class iAccessExamError {
	
	private final String message;
	private final int errorCode;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;
	
	public iAccessExamError(String message, int errorCode, HttpStatus httpStatus, ZonedDateTime timestamp) {
		this.message = message;
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
	}
	
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
