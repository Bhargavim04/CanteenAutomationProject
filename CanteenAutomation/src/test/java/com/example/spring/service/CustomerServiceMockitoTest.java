package com.example.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.RegRespDto;
import com.example.spring.dto.RegisterDto;
import com.example.spring.entity.Address;
import com.example.spring.entity.Customer;
import com.example.spring.entity.Login;
import com.example.spring.exception.CustomerFoundException;
import com.example.spring.exception.CustomerNotFoundException;
import com.example.spring.repository.ICustomerRepository;
import com.example.spring.repository.ILoginRepository;

@ExtendWith(SpringExtension.class)
public class CustomerServiceMockitoTest {

	@InjectMocks
	CustomerServiceImpl cusServ;

	// @MockBean - Creates Mock of a class or interface
	@MockBean
	ICustomerRepository cusRepo;
	
	@MockBean
	ILoginRepository loginRepo;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetCustomerById() throws CustomerNotFoundException {

		Customer cus = new Customer();
		cus.setCusId(10);
		cus.setCusName("Roopa");

		Mockito.when(cusRepo.findById(10)).thenReturn(Optional.of(cus));

		Customer cus1 = cusServ.getCusById(10);
		assertEquals(10, cus1.getCusId());
		assertEquals("Roopa", cus1.getCusName());
	}
	
	@Test
	void testGetAllCustomers() {
		List<Customer> cusList = new ArrayList<Customer>();
		List<Customer> cusList1 = new ArrayList<Customer>();
		Customer cus = new Customer();
		cus.setCusId(10);
		cus.setCusName("Bhavana");
		cusList.add(cus);
		Mockito.when(cusRepo.findAll()).thenReturn(cusList);
		cusList1= cusServ.getAllCustomers();
		assertEquals(cusList, cusList1);
	}
	
	@Test
	void testGetCusDtoById() throws CustomerNotFoundException {
	
		Customer cus = new Customer();
		cus.setCusId(20);
		cus.setCusName("Harish");
		cus.setCusContactNo("8899765466");
		Login login = new Login("harish@gmail.com","harish@123","customer",false);
		cus.setLogin(login);
		
		Mockito.when(cusRepo.findById(20)).thenReturn(Optional.of(cus));

		CustomerDto cusDto = cusServ.getCusDtoById(20);
		assertEquals(20, cusDto.getCusId());
		assertEquals("Harish", cusDto.getCusName());

	}
	
	@Test
	void testGetCusDtoByEmail() throws CustomerNotFoundException {
	
		Customer cus = new Customer();
		cus.setCusId(20);
		cus.setCusName("Harish");
		cus.setCusContactNo("8899765466");
		Login login = new Login("harish@gmail.com","harish@123","customer",false);
		cus.setLogin(login);
		
		Mockito.when(cusRepo.getCusByEmail("harish@gmail.com")).thenReturn(cus);

		Customer cus1 = cusServ.getCusByEmail("harish@gmail.com");
		assertEquals(20, cus1.getCusId());
		assertEquals("Harish", cus1.getCusName());
	}
	
	@Test
	void testAddCustomer() {
		Customer cus = new Customer();
		cus.setCusId(12);
		cus.setCusName("Ram");
		
		Mockito.when(cusRepo.save(cus)).thenReturn(cus);
		Customer cus1= cusServ.addCustomer(cus);
		assertEquals("Ram", cus1.getCusName());
	}
	
//	@Test
//	void testRegCustomer() throws CustomerFoundException {
//		Customer cus = new Customer();
//		cus.setCusName("Rajesh");
//		cus.setCusContactNo("9856433212");
//		Login login = new Login();
//		login.setEmail("rajesh@gmail.com");
//		login.setPassword("rajesh123");
//		login.setRole("customer");
//		cus.setLogin(login);
//		
//	  	Mockito.when(loginRepo.findById("rajesh@gmail.com")).thenReturn(login);
//		Mockito.when(cusRepo.save(cus)).thenReturn(cus);
//		RegisterDto reg = new RegisterDto();
//		reg.setCusName(cus.getCusName());
//		reg.setCusContactNo(cus.getCusContactNo());
//		reg.setEmail(cus.getLogin().getEmail());
//		reg.setPassword(cus.getLogin().getPassword());
//		reg.setRole(cus.getLogin().getRole());
//		
//		RegRespDto resp= cusServ.regCustomer(reg);
//		assertEquals("Rajesh", resp.getCusName());
//	}
	
	@Test
	void testUpdateCustomerById() throws CustomerNotFoundException {
		Address addr = new Address(10,234,"Yelahanka","Bangalore","Karnataka",560064);
		List<Address> list= new ArrayList();
		Login login = new Login("abc@gmail.com","abc@123","customer",false);
		Customer cus = new Customer();
		cus.setCusId(10);
		cus.setCusName("Ravi");
		cus.setCusContactNo("9845600809");
		cus.setAddress(list);
		cus.setLogin(login);
		
		
		Customer updatedCus = new Customer();
		updatedCus.setCusId(10);
		updatedCus.setCusName("Sam");
		updatedCus.setCusContactNo("9845600809");
		updatedCus.setAddress(list);
		updatedCus.setLogin(login);
		
		Mockito.when(cusRepo.findById(10)).thenReturn(Optional.of(cus));
		Mockito.when(cusRepo.save(cus)).thenReturn(updatedCus);
		
		Customer cus2  =cusServ.updateCustomerById(10, cus);
		assertEquals("Sam", cus2.getCusName());
	}
	
	@Test
	void testUpdateCustomerDtoById() throws CustomerNotFoundException {
		CustomerDto cus = new CustomerDto();
		
		Customer updatedCus = new Customer();
		updatedCus.setCusId(75);
		updatedCus.setCusName("Raj Kumar");
		updatedCus.setCusContactNo("8050360809");
		Login login = new Login("raj@gmail.com","raj@123","customer",false);
		updatedCus.setLogin(login);
		
		cus.setCusId(updatedCus.getCusId());
		cus.setCusName(updatedCus.getCusName());
		cus.setCusContactNo(updatedCus.getCusContactNo());
		cus.setEmail(updatedCus.getLogin().getEmail());
		
		Mockito.when(cusRepo.findById(75)).thenReturn(Optional.of(updatedCus));
		Mockito.when(cusRepo.save(updatedCus)).thenReturn(updatedCus);
		
		CustomerDto cus2  =cusServ.updateCusDtoById(75, cus );
		assertEquals("Raj Kumar", cus2.getCusName());
	}
	
	@Test
	void testUpdateCustomerAddr() throws CustomerNotFoundException {
		Address addr = new Address(10,234,"Yelahanka","Bangalore","Karnataka",560064);
		List<Address> listAddr= new ArrayList();
		Login login = new Login("ram@gmail.com","ram@123","customer",false);
		Customer cus = new Customer();
		cus.setCusId(10);
		cus.setCusName("Ravi");
		cus.setCusContactNo("9845600809");
		cus.setAddress(listAddr);
		cus.setLogin(login);
		
		Customer updatedCus = new Customer();
		updatedCus.setCusId(10);
		updatedCus.setCusName("Sam");
		updatedCus.setCusContactNo("9845600809");
		updatedCus.setAddress(listAddr);
		updatedCus.setLogin(login);
		Mockito.when(cusRepo.findById(10)).thenReturn(Optional.of(cus));
		Mockito.when(cusRepo.save(cus)).thenReturn(updatedCus);
		
		Customer cus2  =cusServ.updateCusAddr(10, addr);
		assertEquals(listAddr, cus2.getAddress());
	}
	
	
	@Test
	void testDeleteCustomer() throws CustomerNotFoundException {
		Customer cus = new Customer();
		cus.setCusId(20);
		cus.setCusName("Raji");
		
		Mockito.when(cusRepo.findById(20)).thenReturn(Optional.of(cus));
		//Mockito.when(empRepo.deleteById(10)).
		Customer cus1= cusServ.deleteCustomer(20);
		assertEquals(20, cus1.getCusId());
		
	}

}
