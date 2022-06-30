package com.example.spring.service;

import java.util.Optional;

import com.example.spring.entity.Login;
import com.example.spring.exception.InvalidCredentialsException;

import antlr.collections.List;

/*import antlr.collections.List;*/

public interface ILoginService {
	
	Login login(Login credentials) throws InvalidCredentialsException;

	Login addLogin(Login login);

	Optional<Login> deleteLogin(String email);

	Optional<Login> getLogin(String email);

	List getAllLogin();
	
	/*package com.example.spring.service;

	import com.example.spring.entity.Login;

	public interface ILoginService {

		Login login(Login credentials);*/

	}
