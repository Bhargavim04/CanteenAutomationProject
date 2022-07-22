package com.example.spring.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.spring.entity.ErrorResponse;

@ControllerAdvice
public class AllExceptionHandler {
	
	@ExceptionHandler(OrderInvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleException(OrderInvalidCredentialsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.UNAUTHORIZED.value()); // 401 unauthorized
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);  //404 Not found
	}

	@ExceptionHandler(OrderNotFondException.class)
	public ResponseEntity<ErrorResponse> handleException(OrderNotFondException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	@ExceptionHandler(OrderAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleException(OrderAlreadyExistsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}

}
