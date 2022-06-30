package com.example.spring.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.spring.entity.ErrorResponse;


@ControllerAdvice
public class CartExceptionHandler {

	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CartNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());   //404 not found
		error.setMessage(exception.getMessage());      //get message from exception
		//error.setTimeStamp(System.currentTimeMillis());
		error.setTimeStamp(LocalDateTime.now());    //update system time

		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);    //404 not found
	}
	
//	@ExceptionHandler(InvalidCredentialsException.class)
//	public ResponseEntity<ErrorResponse> handleException(InvalidCredentialsException exception) {
//		ErrorResponse error = new ErrorResponse();
//
//		error.setStatus(HttpStatus.UNAUTHORIZED.value());   //401 not found
//		error.setMessage(exception.getMessage());      //get message from exception
//		//error.setTimeStamp(System.currentTimeMillis());
//		error.setTimeStamp(LocalDateTime.now());    //update system time
//
//		return new ResponseEntity<> (error, HttpStatus.UNAUTHORIZED);  //401 unauthorized
//
//	}




}
