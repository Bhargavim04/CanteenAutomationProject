package com.example.spring.dto;

import lombok.Data;

@Data
public class CanteenFoodDto {
	
	private int foodId ;
	private String foodName;
	private double foodPrice;
	private int foodQuantity;
	private String foodImage;

}
