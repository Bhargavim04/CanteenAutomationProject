package com.example.spring.exception;

public class OrderInvalidCredentialsException extends RuntimeException{
	
	public OrderInvalidCredentialsException(String msg) {
		super(msg);
	}

}
