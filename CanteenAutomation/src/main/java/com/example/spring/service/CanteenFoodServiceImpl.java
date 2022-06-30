package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.CanteenFood;
import com.example.spring.exception.CanteenFoodNotFoundException;
import com.example.spring.repository.CanteenFoodRepository;

@Service
public class CanteenFoodServiceImpl implements ICanteenFoodService {

	private static final CanteenFood CanteenFood = null;
	@Autowired
	CanteenFoodRepository canteenFoodRepository;

	@Override
	public List<CanteenFood> getAllCanteenFood() {
		// TODO Auto-generated method stub
		return canteenFoodRepository.findAll();
	}

	@Override
	public CanteenFood getCanteenById(int foodId) throws CanteenFoodNotFoundException {
		Optional<CanteenFood> food = canteenFoodRepository.findById(foodId);
		if (food.isPresent()) {
			return food.get();
		} else {
			throw new CanteenFoodNotFoundException("CanteenFood not found with food id " + foodId);
		}
	}

	@Override
	public CanteenFood saveCanteenFood(CanteenFood food) {
		// TODO Auto-generated method stub
		return canteenFoodRepository.save(food);
	}

	@Override
	public CanteenFood deleteCanteenFood(int foodId) throws CanteenFoodNotFoundException {
		Optional<CanteenFood> canteenFood = canteenFoodRepository.findById(foodId);
		if (canteenFood.isPresent()) {
			canteenFoodRepository.deleteById(foodId);
		} else {
			throw new CanteenFoodNotFoundException("CanteenFood not found with food id " + foodId);
		}
		return canteenFood.get();
	}

	@Override
	public CanteenFood updateFoodQuantity(int foodId, int foodQuantity) throws CanteenFoodNotFoundException {
		Optional<CanteenFood> canteenFood = canteenFoodRepository.findById(foodId);
		if (canteenFood.isPresent()) {
			CanteenFood cf = canteenFood.get();
			cf.setFoodQuantity(foodQuantity);
			return canteenFoodRepository.save(cf);
		} else {
			throw new CanteenFoodNotFoundException("CanteenFood not found with food id " + foodId);
		}

	}

	@Override
	public com.example.spring.entity.CanteenFood add(com.example.spring.entity.CanteenFood id) {
		// TODO Auto-generated method stub
		return null;
	}

}
