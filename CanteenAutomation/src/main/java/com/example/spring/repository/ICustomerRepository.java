package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	// Native Query
	@Query(value = "select * from customer inner join login on customer.email=login.email where customer.email=:email", nativeQuery = true)
	Customer getCusByEmail(@Param("email") String email);
}
