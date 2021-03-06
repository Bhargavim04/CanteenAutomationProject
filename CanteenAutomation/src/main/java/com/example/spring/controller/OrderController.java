
package com.example.spring.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.OrderEntity;
import com.example.spring.exception.OrderAlreadyExistsException;
import com.example.spring.exception.OrderNotFondException;
import com.example.spring.service.OrderService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	

	@GetMapping("/order")
	public List<OrderEntity> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/order/{id}")
	public Optional<OrderEntity> getOrder(@PathVariable int id) throws OrderNotFondException{
		return orderService.getOrder(id);
	}
	
	@PostMapping("/order")
	public OrderEntity addOrder(@Valid @RequestBody OrderEntity  orderEntity) throws OrderAlreadyExistsException{
		return orderService.addOrder(orderEntity);
	}
	
	@DeleteMapping("/order/{id}")
	public Optional  <OrderEntity> deleteOrder(@PathVariable int id) throws OrderNotFondException{
		return orderService.deleteOrder(id);
	}

	@PutMapping("/order/{id}")
	public OrderEntity updateOrder(@PathVariable int id, @Valid @RequestBody OrderEntity orderEntity) throws OrderNotFondException{
		return orderService.updateOrder(id, orderEntity);
	}

}
