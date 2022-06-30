package com.example.spring.service;

import com.example.spring.entity.Login;
import com.example.spring.exception.InvalidCredentialsException;

public interface ILoginService {

	Login login(Login credentials) throws InvalidCredentialsException;


}
