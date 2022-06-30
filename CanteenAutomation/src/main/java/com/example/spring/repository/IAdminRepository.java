package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Admin;
import com.example.spring.entity.Staff;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{

	
}