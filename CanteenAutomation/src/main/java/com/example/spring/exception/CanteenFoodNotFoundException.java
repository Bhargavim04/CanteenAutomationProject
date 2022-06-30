package com.example.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CanteenFoodNotFoundException extends Exception {

	private static final long serialVesionUID = 1L;
	private String foodName;
	private String foodImage;
	private int foodId;
	private double foodPrice;
	private int foodQuantity;

	public CanteenFoodNotFoundException(String foodName, String foodImage, int foodId, double foodPrice,
			int foodQuantity) {
		super(String.format(" %s not found with %s:'%s'", foodId, foodName, foodImage, foodPrice, foodQuantity));
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodImage = foodImage;
		this.foodPrice = foodPrice;
		this.foodQuantity = foodQuantity;
	}

	public CanteenFoodNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}

	public int getFoodId() {
		return foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public String getFoodImage() {
		return foodImage;
	}

	public double foodPrice() {
		return foodPrice;
	}

	public int foodQuantity() {
		return foodQuantity;
	}

	public static long getSerialvesionuid() {
		return serialVesionUID;
	}

}
