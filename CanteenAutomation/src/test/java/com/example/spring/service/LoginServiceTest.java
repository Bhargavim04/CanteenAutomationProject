package com.example.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.dto.LoginDto;
import com.example.spring.dto.LoginRespDto;
import com.example.spring.entity.Login;
import com.example.spring.exception.EmailNotFoundException;
import com.example.spring.exception.InvalidCredentialsException;

@SpringBootTest
public class LoginServiceTest {

	@Autowired
	ILoginService loginServ;
	
	@Test
	void testLogin() throws InvalidCredentialsException {
		Login login = new Login("sneha@gmail.com","sneha123","customer",true);
		Login newLogin = loginServ.login(login);
		assertEquals("sneha@gmail.com",newLogin.getEmail());
	}
	
	@Test
	void testLoginDto() throws InvalidCredentialsException {
		LoginDto login = new LoginDto("ram@gmail.com","ram123","customer");
		LoginRespDto newLogin = loginServ.login(login);
		assertEquals("ram@gmail.com",newLogin.getEmail());
	}
	
	@Test
	void testLogout() throws InvalidCredentialsException, EmailNotFoundException {
		//LoginDto login = new LoginDto("ram@gmail.com","ram123","customer");
		LoginRespDto logout = loginServ.logout("sneha@gmail.com");
		assertEquals(false,logout.isLoggedIn());
	}
}
