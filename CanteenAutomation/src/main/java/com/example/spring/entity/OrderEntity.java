package com.example.spring.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class OrderEntity {
	@GeneratedValue
	@Id
	@Min(1)
	private int orderId;
	
	@NotNull(message = "customerName is mandatory")
	private String customerName;
	
	@NotNull(message = "cartItems is mandatory")
	private String cartItems;
	
	@NotNull(message = "address is mandatory")
	private String address;
	
	@NotNull(message = "date is mandatory")
	private LocalDate date;

	public OrderEntity() {
		super();
	}

	public OrderEntity(@Min(1) int orderId, @NotNull(message = "customerName is mandatory") String customerName,
			@NotNull(message = "cartItems is mandatory") String cartItems,
			@NotNull(message = "address is mandatory") String address,
			@NotNull(message = "date is mandatory") LocalDate date) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.cartItems = cartItems;
		this.address = address;
		this.date = date;
	}

	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCartItems() {
		return cartItems;
	}

	public void setCartItems(String cartItems) {
		this.cartItems = cartItems;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
     


	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", customerName=" + customerName + ", cartItems=" + cartItems
				+ ", address=" + address + ", date=" + date + "]";
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
