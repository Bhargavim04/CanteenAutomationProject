package com.example.spring.exception;

public class OrderNotFondException extends RuntimeException {


	private static final long serialVersionUID = -2418773242468470956L;

	public OrderNotFondException() {
	}

	public OrderNotFondException(String message) {
		super(message);
	}
}
