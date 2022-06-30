package com.example.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.spring.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{
	
	//Custom query mathods
	List<Payment> findByPaymentId(int PaymentId);
	List<Payment> findByTotalPayment(double Payment);
	List<Payment> findByPaymentType(String PaymentType);
   

}
