package com.example.spring.service;

import java.util.List;

import javax.validation.Valid;

import com.example.spring.dto.PaymentDto;
import com.example.spring.entity.Payment;
import com.example.spring.exception.PaymentNotFoundException;

public interface IPaymentService {

	List<Payment> getAllPayments();

	Payment getPaymentById(int paymentid) throws PaymentNotFoundException;

	List<Payment> getPaymentByTotalPayment(double payment);

	List<Payment> getPaymentByPaymentType(String creditCard);

	Payment addPayment(@Valid Payment payment);

	Payment deletePayment(int paymentId);

	Payment updatePaymentById(int paymentId, Payment payment) throws PaymentNotFoundException;

	PaymentDto getpaymentDtoById(int paymentId);

}
