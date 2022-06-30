package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="Order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	private String OrderName;
	private String OrderDescription;
	private String address;
	
	public Order(@JsonProperty("id")Long id,
			@JsonProperty("name")String orderName,
			@JsonProperty("description")String orderDescription,
			@JsonProperty("address")String address) {
		OrderName = orderName;
		OrderDescription = orderDescription;
		this.address = address;
	}
	
	public String getOrderName() {
		return OrderName;
	}
	public void setOrderName(String orderName) {
		OrderName = orderName;
	}
	public String getOrderDescription() {
		return OrderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		OrderDescription = orderDescription;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Order Name:"+this.OrderName+", Order Description:"+this.OrderDescription+", Address:"
				+this.address;
	}
	
	
}
