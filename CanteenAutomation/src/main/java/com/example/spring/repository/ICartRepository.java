package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Cart;
import com.example.spring.entity.FoodItem;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {

	FoodItem save(FoodItem foodItem);

}
