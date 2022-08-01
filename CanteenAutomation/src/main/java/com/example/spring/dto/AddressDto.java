package com.example.spring.dto;

import java.util.List;

import com.example.spring.entity.Address;

import lombok.Data;

@Data
public class AddressDto {

	private List<Address> address;
}
