package com.example.springCore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springCore.entity.Payment;
import com.example.springCore.entity.Login;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;

@SpringBootTest
public class PaymentServiceTest {
	
	@Autowired
	IPaymentService paymentServ;
	
	//TDD-Test Driver Development
	//add payment
	@Test
	@Disabled
	@Tag("skip")
	void testAddPayment() {
		Payment payment = new Payment();
		payment.setPaymentId(0);
		/*payment.setTotalPayment(5000);
		payment.setPaymentType("CreditCard");*/
		
		Login login = new Login();
		login.setEmail("vijaya@gmail.com");
		login.setPassword("vijaya@123");
		payment.setLogin(login);
		
		}
	@Test
	void GetAllPayments() {
		List<Payment> payments = paymentServ.getAllPayments();
		assertEquals(1, payments.size());
		Payment payment = payments.get(0);
		assertEquals(2, payment.getPaymentId());
	}

}
