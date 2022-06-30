package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Admin {

	@Id
	@GeneratedValue
	private int adminId;
	@NotNull(message = "Name should not be empty")
	private String name;
	@Size(min=10, max=10, message="Ony 10 digits Mobile Number is allowed")
	private String conNo;
}
