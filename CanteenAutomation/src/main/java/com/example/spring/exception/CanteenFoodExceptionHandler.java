package com.example.spring.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.spring.entity.ErrorResponse;
@ControllerAdvice
public class CanteenFoodExceptionHandler {
	
	@ExceptionHandler(CanteenFoodNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CanteenFoodNotFoundException exception){
		ErrorResponse error=new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
