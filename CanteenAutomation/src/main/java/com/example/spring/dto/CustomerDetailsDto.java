package com.example.spring.dto;

import java.util.List;

import com.example.spring.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDto {

	private int cusId;
	private String cusName;
	private String cusContactNo;
	private String email;
	private List<Address> address;
}
