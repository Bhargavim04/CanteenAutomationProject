package com.example.spring.exception;

public class OrderNotFondException extends RuntimeException {

	public OrderNotFondException(String message) {
		super(message);
	}
}
