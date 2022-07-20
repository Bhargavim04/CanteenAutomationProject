package com.example.spring.dto;

import lombok.Data;

@Data
public class AddressDto {

	private int houseNo;
	private String street;
	private String city;
	private String state;
	private int pinCode;
	
}
