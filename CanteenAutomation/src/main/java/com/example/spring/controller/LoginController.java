package com.example.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Login;
import com.example.spring.exception.InvalidCredentialsException;
import com.example.spring.service.ILoginService;

@RestController
public class LoginController {

	@Autowired
	ILoginService loginServ;

	@PostMapping("/login")
	ResponseEntity<Login> login(@Valid @RequestBody Login credentials) throws InvalidCredentialsException {
		Login login= loginServ.login(credentials);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
}