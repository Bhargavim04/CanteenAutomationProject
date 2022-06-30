package com.example.spring.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
/*
import javax.persistence.OneToOne;*/
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Payment {
	
	@Id
	@GeneratedValue
	/*private int paymentId;*/
	
	private int paymentId;
	
	@DecimalMax(value="5000", message="total payment shouldn't be lesthan 5000")
	private double totalPayment;
	
	@NotNull(message="Name shouldn't be empty")
	@Size(min=3, max=10, message="min 3 and max 10 characters are allowed")
	private String paymentType;
	/*
	//oneToOne unidirectional relationship
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="email")
	private Login login;*/

	public void setLogin(Login login) {
		// TODO Auto-generated method stub
		
	}

}
