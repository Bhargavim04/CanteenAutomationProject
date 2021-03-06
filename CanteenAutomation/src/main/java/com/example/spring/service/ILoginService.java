package com.example.spring.service;

import com.example.spring.dto.LoginDto;
import com.example.spring.dto.LoginRespDto;
import com.example.spring.entity.Customer;
import com.example.spring.entity.Login;
import com.example.spring.exception.EmailNotFoundException;
import com.example.spring.exception.InvalidCredentialsException;

public interface ILoginService {

	Login login(Login credentials) throws InvalidCredentialsException;

	LoginRespDto login(LoginDto loginDto) throws InvalidCredentialsException;

	LoginRespDto logout(String email) throws EmailNotFoundException;


}
