package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.Order;

public interface OrderService {
	public Order createOrder(Order order);
	public List<Order> listAllOrders();
	public Order selectOrderById(Long id);
	public Long deleteOrderById(Long id);
	public Long updateOrderById(Long id,Order order);
}
