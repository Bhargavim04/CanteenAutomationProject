package com.example.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{

}


