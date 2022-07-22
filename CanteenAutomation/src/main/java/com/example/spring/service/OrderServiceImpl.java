package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.OrderEntity;
import com.example.spring.exception.OrderAlreadyExistsException;
import com.example.spring.exception.OrderNotFondException;
import com.example.spring.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<OrderEntity> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<OrderEntity> getOrder(int id) throws OrderNotFondException {
		Optional<OrderEntity> orderData = orderRepository.findById(id);
		if(!orderData.isEmpty()) {
			return orderRepository.findById(id);
		}
		else {
			throw new OrderNotFondException("order Not Found with id "+id);
		}
	}

	@Override
	public OrderEntity addOrder(OrderEntity orderEntity) throws OrderAlreadyExistsException {
		Optional<OrderEntity> orderData = orderRepository.findById(orderEntity.getOrderId());
		if(orderData.isEmpty()) {
			return orderRepository.save(orderEntity);
		}
		else {
			throw new OrderAlreadyExistsException("Order already exists with id "+orderEntity.getOrderId());
		}
	}

	@Override
	public Optional<OrderEntity> deleteOrder(int id) throws OrderNotFondException {
		Optional<OrderEntity> orderData = orderRepository.findById(id);
		if(!orderData.isEmpty()) {
			orderRepository.deleteById(id);
			return orderData;
		}
		else {
			throw new OrderNotFondException("Order Not Found with id "+id);
		}
	}

	@Override
	public OrderEntity updateOrder(int id, OrderEntity orderEntity) throws OrderNotFondException {
		Optional<OrderEntity> orderData = orderRepository.findById(id);
		if(!orderData.isEmpty()) {
			orderEntity.setOrderId(id);
			return orderRepository.save(orderEntity);
		}
		else {
			throw new OrderNotFondException("Order Not Found with id "+id);
		}
	}

}
