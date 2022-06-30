package com.example.canteen.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.canteen.entity.Order;
import com.example.canteen.service.OrderService;

@RestController
@RequestMapping(path="/order")
public class OrderController {
	@Autowired
	  private OrderService orderService;
	  
	  public OrderController(OrderService orderService) {
	    this.orderService=orderService;
	  }
	  
	  @PostMapping(path="/create")
	  public Order createOrder(@RequestBody Order order) {
	    System.out.println(order.toString());
	    return orderService.createOrder(order);
	  }
	  
	  @GetMapping(path="/list")
	  private List<Order> listAllOrders(){
	    return orderService.listAllOrders();
	  }
	  
	  @GetMapping(path="/{id}")
	  private Order getOrderDetailsById(@PathVariable("id") Long id) {
	    return orderService.selectOrderById(id).orElse(null);
	  }
	  @PutMapping(path="/update")
	  public Long updateOrder(@RequestBody Order order) {
	    return orderService.updateOrderById(order.getId(), order);
	  }
	  @DeleteMapping(path="/{id}")
	  private void deleteOrderById(@PathVariable("id") Long id) {
	    orderService.deleteOrderById(id);
	  }
	}

