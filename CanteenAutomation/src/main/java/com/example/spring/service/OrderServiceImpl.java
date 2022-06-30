package com.example.canteen.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.canteen.entity.Order;
import com.example.canteen.repository.OrderRepository;

@Service
public class OrderServiceImpl  implements OrderService{
	private final OrderRepository orderRepository;
	  
	  public OrderServiceImpl(OrderRepository orderRepository) {
	    this.orderRepository=orderRepository;
	  }
	  @Override
	  public Order createOrder(Order order) {
	    return orderRepository.insertOrder(order);
	  }

	  @Override
	  public List<Order> listAllOrders() {
	    return orderRepository.listAllOrders();
	  }
	  @Override
	  public Optional<Order> selectOrderById(Long id){
	    return orderRepository.selectOrderById(id);
	  }
	  @Override
	  public Long deleteOrderById(Long id) {
	    return orderRepository.deleteOrderById(id);
	  }
	  @Override
	  public Long updateOrderById(Long id, Order order) {
	    return orderRepository.updateOrderById(id, order);
	  }
	}

