package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.CanteenFood;
import com.example.spring.exception.CanteenFoodNotFoundException;

public interface ICanteenFoodService {
	CanteenFood add(CanteenFood id);

	List<CanteenFood> getAllCanteenFood();

	CanteenFood getCanteenById(int foodId) throws CanteenFoodNotFoundException ;
	
	CanteenFood deleteCanteenFood(int foodId) throws CanteenFoodNotFoundException ;

	CanteenFood updateFoodQuantity(int foodId, int foodQuantity) throws CanteenFoodNotFoundException ;

	CanteenFood saveCanteenFood(CanteenFood foodId);

}
