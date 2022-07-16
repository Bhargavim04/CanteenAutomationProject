package com.example.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Login;
import com.example.spring.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;

	@Override
	public Login login(Login credentials) {

		return loginRepo.save(credentials);

	}

}
