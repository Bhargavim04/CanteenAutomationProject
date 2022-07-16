package com.example.spring.dto;

import lombok.Data;

@Data
public class RegisterDto {
	
	private String cusName;
	private String cusContactNo;
	private String email;
	private String password;
	private String role;
}
