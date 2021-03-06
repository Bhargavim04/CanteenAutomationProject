package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Payment {

	@Id
	@GeneratedValue
	private int paymentId;

	@DecimalMax(value = "5000", message = "total payment shouldn't be lesthan 5000")
	private double totalPayment;

	@NotNull(message = "Name shouldn't be empty")
	@Size(min = 3, max = 10, message = "min 3 and max 10 characters are allowed")
	private String paymentType;
	

}
