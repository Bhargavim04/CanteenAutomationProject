package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
	
	private String cusName;
	private String cusContactNo;
	private String email;
	private String password;
	private String role;
}
