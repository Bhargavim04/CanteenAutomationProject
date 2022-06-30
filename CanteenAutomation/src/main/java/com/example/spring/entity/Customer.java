package com.example.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue
	private int cusId;

	@NotNull(message = "Name shouldn't be empty")
	@Size(min = 3, max = 10, message = "Min 3 and max 10 charecters are allowed")
	private String cusName;

	@Size(min = 10, max = 10, message = "Ony 10 digits Mobile Number is allowed")
	private String cusContactNo;
	
	// OneToMany unidirectional relationship
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "email")
	private Login login;
	
	// OneToMany unidirectional relationship
	@JsonIgnore
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "cusId")
	private List<Address> address;

	public Customer(int cusId, String cusName, String cusContactNo) {
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusContactNo = cusContactNo;
	}

}
