package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Staff {

	@Id
	@GeneratedValue
	private int staffId;
	@NotNull(message = "Name should not be empty")
	private String name;
	@Size(min = 10, max = 10, message = "conNo should be of 10character")
	private String conNo;
}
