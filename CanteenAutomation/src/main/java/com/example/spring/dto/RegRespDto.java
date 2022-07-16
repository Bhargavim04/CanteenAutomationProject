package com.example.spring.dto;

import lombok.Data;

@Data
public class RegRespDto {

	private String cusName;
	private String cusContactNo;
	private String email;
	private boolean isLoggedIn ;
	private String role;
}
