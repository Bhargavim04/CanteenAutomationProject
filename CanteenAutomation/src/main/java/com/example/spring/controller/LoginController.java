package com.example.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.LoginDto;
import com.example.spring.dto.LoginRespDto;
import com.example.spring.entity.Customer;
import com.example.spring.entity.Login;
import com.example.spring.exception.EmailNotFoundException;
import com.example.spring.exception.InvalidCredentialsException;
import com.example.spring.service.ILoginService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	ILoginService loginServ;

	@PostMapping("/login")
	ResponseEntity<Login> login(@Valid @RequestBody Login credentials) throws InvalidCredentialsException {
		Login login= loginServ.login(credentials);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PostMapping("/login/dto")
	ResponseEntity<LoginRespDto> login(@RequestBody LoginDto loginDto) throws InvalidCredentialsException {
		LoginRespDto login= loginServ.login(loginDto);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PatchMapping("/logout/{email}")
	ResponseEntity<LoginRespDto> logout(@PathVariable String email) throws EmailNotFoundException {
		LoginRespDto resp = loginServ.logout(email);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
}