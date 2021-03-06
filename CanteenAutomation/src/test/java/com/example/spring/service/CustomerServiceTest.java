package com.example.spring.service;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.RegRespDto;
import com.example.spring.dto.RegisterDto;
import com.example.spring.entity.Customer;
import com.example.spring.exception.CustomerFoundException;
import com.example.spring.exception.CustomerNotFoundException;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	ICustomerService cusServ;
	
	@Test
	@Disabled
	void testGetAllCustomers() {
		List<Customer> customers = cusServ.getAllCustomers();
		assertEquals(2, customers.size(), "Entered number of customers are not present");
		Customer cus = customers.get(0);
		assertEquals("Priya", cus.getCusName(),"Name is not available");
	}
	
	@Test
	//@Disabled
	void testGetCustomerById() throws CustomerNotFoundException {
		Customer customer = cusServ.getCusById(61);
		assertEquals(61,customer.getCusId());
	}
	
	@Test
	//@Disabled
	void testGetCustomerDtoById() throws CustomerNotFoundException {
		CustomerDto customerDto = cusServ.getCusDtoById(61);
		assertEquals(61,customerDto.getCusId());
	}
	
	@Test
	//@Disabled
	void testGetCusByEmail() throws CustomerNotFoundException {
		Customer customer = cusServ.getCusByEmail("sneha@gmail.com");
		assertEquals("sneha@gmail.com",customer.getLogin().getEmail());
	}
	
	@Test
	@Disabled
	void testAddCustomer() {
		Customer cus = new Customer(0,"Divya","8745326526");
		Customer newCus= cusServ.addCustomer(cus);
		assertEquals("Divya", newCus.getCusName());
	}
	
	@Test
	@Disabled
	void testRegCustomer() throws CustomerFoundException {
		RegisterDto reg = new RegisterDto("kavya","8745326526","kavya@gmail.com","kavya123","customer");
		RegRespDto resp= cusServ.regCustomer(reg);
		assertEquals("Kavya", resp.getCusName());
	}
	
	@Test
	@Disabled
	void testUpdateCustomerById() throws CustomerNotFoundException {
		Customer updatedCustomer = new Customer(13,"Anu","8956777853");
		Customer cus = cusServ.updateCustomerById(13, updatedCustomer);
		assertEquals(updatedCustomer, cus);
	}
	
	@Test
	@Disabled
	void testUpdateCustomerDtoById() throws CustomerNotFoundException {
		CustomerDto updatedCustomer = new CustomerDto(84,"Kavya H","8956777853","kavya@gmail.com");
		CustomerDto cus = cusServ.updateCusDtoById(84, updatedCustomer);
		assertEquals(updatedCustomer, cus);
	}
	
	@Test
	@Disabled
	void testDeleteCustomer() throws CustomerNotFoundException {
		Customer cus = cusServ.deleteCustomer(11);
		assertEquals(11, cus.getCusId());
	}

	
}
