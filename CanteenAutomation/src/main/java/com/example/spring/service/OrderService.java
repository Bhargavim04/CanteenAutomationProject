package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring.entity.OrderEntity;
import com.example.spring.exception.OrderAlreadyExistsException;
import com.example.spring.exception.OrderNotFondException;



@Service
public interface OrderService {
	
	public List<OrderEntity> getAllOrders();
	
	public Optional<OrderEntity> getOrder(int id) throws OrderNotFondException;
	
	public OrderEntity addOrder(OrderEntity  orderEntity) throws OrderAlreadyExistsException;
	
	public Optional<OrderEntity> deleteOrder(int id) throws OrderNotFondException;
	
	public OrderEntity updateOrder(int id, OrderEntity orderEntity) throws OrderNotFondException;

}
