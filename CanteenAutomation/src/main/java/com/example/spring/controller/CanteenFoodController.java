package com.example.spring.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.CanteenFood;
import com.example.spring.exception.CanteenFoodNotFoundException;
import com.example.spring.service.ICanteenFoodService;

@RestController
public class CanteenFoodController {

	@Autowired
	ICanteenFoodService canteenServ;

	// get all CanteenFood details
	@GetMapping("/CanteenFood")
	ResponseEntity<List<CanteenFood>> getAllCanteenFood() {
		List<CanteenFood> canteenFood = canteenServ.getAllCanteenFood();
		return new ResponseEntity<>(canteenFood, HttpStatus.OK);

	}

	// get CanteenFood based on CanteenFood id
	@GetMapping("/CanteenFood/{id}")
	ResponseEntity<CanteenFood> getCanteenById(@PathVariable("id") int foodId) throws CanteenFoodNotFoundException {
		CanteenFood food = canteenServ.getCanteenById(foodId);
		return new ResponseEntity<>(food, HttpStatus.OK);
	}

	// add new CanteenFood
	@PostMapping("/CanteenFood")
	ResponseEntity<CanteenFood> saveCanteenFood(@RequestBody CanteenFood food) {
		CanteenFood newFood = canteenServ.saveCanteenFood(food);
		return new ResponseEntity<>(newFood, HttpStatus.CREATED);
	}

	// update CanteenFood quantity details
	@PatchMapping("/CanteenFood/FoodQuantity/{id}")
	ResponseEntity<CanteenFood> updateFoodQuantity(@PathVariable("id") int foodId, int foodQuantity)
			throws CanteenFoodNotFoundException {
		CanteenFood food1 = canteenServ.updateFoodQuantity(foodId, foodQuantity);
		return new ResponseEntity<>(food1, HttpStatus.OK);
	}

	// delete CanteenFood
	@DeleteMapping("/CanteenFood/{id}")
	ResponseEntity<CanteenFood> deleteCanteenFood(@PathVariable("id") int foodId) throws CanteenFoodNotFoundException {
		CanteenFood food2 = canteenServ.deleteCanteenFood(foodId);
		return new ResponseEntity<>(food2, HttpStatus.OK);
	}

}
