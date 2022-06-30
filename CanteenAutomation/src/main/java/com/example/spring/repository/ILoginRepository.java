package com.example.springCore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springCore.entity.Login;


@Repository
public interface ILoginRepository extends JpaRepository<Login, String>{

}
