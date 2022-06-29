package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Address;
import com.example.spring.entity.Customer;
import com.example.spring.exception.CustomerNotFoundException;
import com.example.spring.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository cusRepo;

	// get all customer details
	@Override
	public List<Customer> getAllCustomers() {

		return cusRepo.findAll();
	}

	// get customer based on customer ID
	@Override
	public Customer getCusById(int cusId) throws CustomerNotFoundException {
		Optional<Customer> cus = cusRepo.findById(cusId);
		if (cus.isPresent()) {
			return cus.get();
		} else {
			throw new CustomerNotFoundException("Customer not found with this id " + cusId);
		}
	}

	// add new customer
	@Override
	public Customer addCustomer(Customer cus) {

		return cusRepo.save(cus);
	}

	@Override
	public Customer updateCustomerById(int cusId, Customer cus) throws CustomerNotFoundException {
		// find customer based on id
		Optional<Customer> dbCus = cusRepo.findById(cusId);

		// if customer present, update customer with new details else return exception
		if (dbCus.isPresent()) {
			return cusRepo.save(cus);
		} else {
			throw new CustomerNotFoundException("Customer not found with this id " + cusId);
		}

	}

	// Update customer address by Id
	@Override
	public Customer updateCusAddr(int cusId, Address newAddr) throws CustomerNotFoundException {
		// find customer by Id
		Optional<Customer> cus = cusRepo.findById(cusId);
		if (cus.isPresent()) {
			// update address
			// get customer from optional container
			Customer dbCus = cus.get();

			// add new address to the existing customer
			dbCus.getAddress().add(newAddr);

			// update customer details in db
			return cusRepo.save(dbCus);
		} else {
			throw new CustomerNotFoundException("Customer not found with this id " + cusId);
		}

	}

	// delete customer based on Id
	@Override
	public Customer deleteCustomer(int cusId) throws CustomerNotFoundException {
		// find customer based on customer id
		Optional<Customer> cus = cusRepo.findById(cusId);

		// delete customer if present else return null
		if (cus.isPresent()) {
			cusRepo.deleteById(cusId);
		} else {
			throw new CustomerNotFoundException("Customer not found with this id " + cusId);
		}
		// return customer
		return cus.get();
	}

}
