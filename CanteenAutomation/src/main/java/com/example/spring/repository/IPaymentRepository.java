package com.example.springCore.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.springCore.entity.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer>{
	
	//Custome query mathods
	List<Payment> findByPaymentId(int PaymentId);
	List<Payment> findByTotalPayment(double Payment);
	List<Payment> findByPaymentType(String PaymentType);
   

}
