package com.example.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring.entity.Address;
import com.example.spring.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	IAddressRepository addRepo;

	@Override
	public List<Address> getAllAddresses() {

		return addRepo.findAll();
	}

	@Override
	public Address deleteAddress(int addrId) {

		// find address based on address id
		Optional<Address> addr = addRepo.findById(addrId);

		// delete address if present else return null
		if (addr.isPresent()) {
			addRepo.deleteById(addrId);
		} else {
			return null;
		}
		// return address
		return addr.get();
	}

}
