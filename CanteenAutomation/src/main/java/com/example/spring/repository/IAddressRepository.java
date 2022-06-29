package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer>{

}
