package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {

	@Id
	@Email(message = "Enter valid email address")
	private String email;
	private String password;
	private String role = "customer";
	private boolean isLoggedIn = false;
}
