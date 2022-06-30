package com.example.springCore.service;

import java.util.List;

import com.example.springCore.entity.Payment;
import com.example.springCore.exception.PaymentNotFoundException;

public interface IPaymentService  {
	
	//get All payments

	List<Payment> getAllPayments();
	
	Payment getPaymentById(int paymentid);
	List<Payment> getPaymentByTotalPayment(double totalPayment);
	//List<Payment> getPaymentByPaymentType(String paymentType);
    List<Payment> getPaymentByPaymentType(String CreditCard);
   Payment updatePaymentById(int paymentId, Payment payment);
   List<Payment> getAllPayment();
   Payment getPayById(int payId);
   Payment updatePaymentId(int payId);
   Payment addPayment(Payment payment);

Payment addPayment1(Payment payment);
	
	





}
