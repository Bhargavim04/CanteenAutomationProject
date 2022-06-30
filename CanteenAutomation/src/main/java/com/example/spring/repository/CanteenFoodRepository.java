package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.spring.entity.CanteenFood;
import com.example.spring.repository.ICanteenFoodRepository;

@Repository
public interface CanteenFoodRepository extends JpaRepository<CanteenFood,Integer> {

	//CanteenFood add(CanteenFood id);

}
