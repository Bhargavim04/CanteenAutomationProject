package com.example.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.PaymentDto;
import com.example.spring.entity.Payment;
import com.example.spring.exception.PaymentNotFoundException;
import com.example.spring.repository.IPaymentRepository;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	IPaymentRepository payRepo;

	@Override
	public List<Payment> getAllPayments() {
		return payRepo.findAll();
	}

	@Override
	public Payment addPayment(Payment payment) {
		return payRepo.save(payment);
	}

	@Override
	public Payment getPaymentById(int paymentId) throws PaymentNotFoundException {

		Optional<Payment> pay = payRepo.findById(paymentId);
		if (pay.isPresent()) {
			return pay.get();
		} else {
			throw new PaymentNotFoundException("paymentId not found with this is id" + paymentId);

		}

	}

	@Override
	public List<Payment> getPaymentByTotalPayment(double TotalPayment) {

		return payRepo.findByTotalPayment(TotalPayment);
	}

	@Override
	public List<Payment> getPaymentByPaymentType(String PaymentType) {

		return payRepo.findByPaymentType(PaymentType);
	}

	@Override
	public Payment deletePayment(int paymentId) {
		// find payment based on payment id
		Optional<Payment> payment = payRepo.findById(paymentId);

		// delete payment if present else return null or throw exception
		if (payment.isPresent()) {
			payRepo.deleteById(paymentId);
		} else {
			return null;
		}
		// return payment
		return payment.get();
	}

	@Override
	public Payment updatePaymentById(int paymentId, Payment payment) throws PaymentNotFoundException {
		// find payment based on id
		Optional<Payment> dbPayment = payRepo.findById(paymentId);

		// if payment present, update payment with new details else return
		// exception/null
		if (dbPayment.isPresent()) {
			return payRepo.save(payment);
		} else {
			throw new PaymentNotFoundException("Payment not found with payment id " + paymentId);
		}
	}

	@Override
	public PaymentDto getpaymentDtoById(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
