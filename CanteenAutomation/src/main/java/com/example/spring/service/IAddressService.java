package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.Address;

public interface IAddressService {

	List<Address> getAllAddresses();

	Address deleteAddress(int addrId);

}
