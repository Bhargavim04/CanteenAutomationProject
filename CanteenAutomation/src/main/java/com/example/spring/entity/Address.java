package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue
	private int addrId;
	@NotNull(message="House Number shouldn't be empty")
	private int houseNo;
	@NotNull(message="Street address shouldn't be empty")
	private String street;
	@NotNull(message="City Name shouldn't be empty")
	private String city;
	@NotNull(message="State name shouldn't be empty")
	private String state;
	@NotNull(message="Pincode shouldn't be empty")
	private int pinCode;

}
