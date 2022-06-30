package com.example.springCore.entity;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Table(name="login")
@Data
public class Login {
	*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.Data;

@Entity
@Data
public class Login {

	@Id
	@Email(message="Enter valid email address")
	private String email;
	private String password;
}
