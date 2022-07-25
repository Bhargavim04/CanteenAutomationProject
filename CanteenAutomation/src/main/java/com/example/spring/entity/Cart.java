package com.example.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;

import lombok.Data;

@Entity
@Data
public class Cart {

	@Id
	@GeneratedValue
	private int cartId;
	@DecimalMin(value = "100", message = "Cart should contain minimum 100 price")
	private double cartTotal;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "itemId")
	private Customer customer;

	// @JsonIgnore
	@OneToMany(targetEntity = CanteenFood.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId", referencedColumnName = "cartId")
	private List<CanteenFood> canteenFood;
}
