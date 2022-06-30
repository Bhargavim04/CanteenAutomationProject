package com.example.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler {
	@ExceptionHandler(OrderIdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFound(OrderIdNotFoundException orderIdNotFoundException){
		return new ResponseEntity<String>("Order Id that You Entered is not there",HttpStatus.BAD_REQUEST);
	}
}
