package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Address;
import com.example.spring.entity.Customer;
import com.example.spring.exception.CustomerNotFoundException;
import com.example.spring.service.IAddressService;

@RestController
@CrossOrigin
public class AddressController {

	@Autowired
	IAddressService addServ;

	// get all address details
	@GetMapping("/addresses")
	ResponseEntity<List<Address>> getAllAddresses() {
		List<Address> addresses = addServ.getAllAddresses();
		return new ResponseEntity<>(addresses, HttpStatus.OK);
	}

	// delete address
	@DeleteMapping("/address/{id}")
	ResponseEntity<Address> deleteAddress(@PathVariable("id") int addrId) {
		Address addr = addServ.deleteAddress(addrId);
		return new ResponseEntity<>(addr, HttpStatus.OK);
	}
}
