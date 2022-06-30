package com.example.spring.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.spring.entity.Order;
import com.example.spring.exception.OrderIdNotFoundException;

@Repository
public class OrderRepository {
	
	private static List<Order> listOfOrders =  new ArrayList<>();
	public Order insertOrder(Order order) {
		listOfOrders.add(new Order(order.getId(),order.getOrderName(),order.getOrderDescription(), order.getAddress()));
		return order;
	}
	
	
	public List<Order> listAllOrders(){
		return listOfOrders;
	}
	
	public Order selectOrderById(Long id){
		Optional<Order> order=listOfOrders.stream().filter(od->od.getId().equals(id)).findFirst();
		if(order.isEmpty()) {
			throw new OrderIdNotFoundException("404","Order Id Not found in the DataBase");
		}
		return order.get();
	}
	
	public Long deleteOrderById(Long id) {
		Order order =selectOrderById(id);
		listOfOrders.remove(order);
		return id;
	}
	
	public Long updateOrderById(Long id,Order order) {
		int indexOfOrder=listOfOrders.indexOf(selectOrderById(id));
		listOfOrders.set(indexOfOrder, order);
		return (long)1;
	}
}
