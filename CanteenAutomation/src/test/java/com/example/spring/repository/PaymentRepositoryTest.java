package com.example.spring.repository;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.example.spring.entity.Payment;

@SpringBootTest
public class PaymentRepositoryTest {

	@Autowired
	IPaymentRepository paymentRepository;

	@Test
	@Disabled
	void testGetPaymentById() {
		List<Payment> payments = paymentRepository.findByPaymentId(2);
		assertEquals(1, payments.size());
	}

	@Test
	@Disabled
	void testGetTotalPayment() {
		List<Payment> payments = paymentRepository.findByTotalPayment(5000);
		assertEquals(1, payments.size());
	}

	@Test
	@Disabled
	void testGetPaymentType() {
		List<Payment> payments = paymentRepository.findByPaymentType("creditcard");
		assertEquals(0, payments.size());

	}

}
