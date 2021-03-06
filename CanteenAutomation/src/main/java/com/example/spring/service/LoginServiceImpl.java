package com.example.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.LoginDto;
import com.example.spring.dto.LoginRespDto;
import com.example.spring.entity.Customer;
import com.example.spring.entity.Login;
import com.example.spring.exception.EmailNotFoundException;
import com.example.spring.exception.InvalidCredentialsException;
import com.example.spring.repository.ICustomerRepository;
import com.example.spring.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	
	@Autowired
	ICustomerRepository cusRepo;
	
	@Override
	public Login login(Login credentials) {

		return loginRepo.save(credentials);

	}

	@Override
	public LoginRespDto login(LoginDto loginDto) throws InvalidCredentialsException {
		
		Optional<Login> dbLoginOpt = loginRepo.findById(loginDto.getEmail());

		if (dbLoginOpt.isPresent()) {
			// compare db password with user provided password
			// if password matching return credentials else throw exception
			Login login = dbLoginOpt.get();
			if (login.getPassword().equals(loginDto.getPassword())
					&& login.getRole().equals(loginDto.getRole())) {
				
				// if credentials matches, set loggedIn flag as true and save
				login.setLoggedIn(true);
				Login updatedLogin = loginRepo.save(login);
				
				 //convert Login to LoginRespDto Obj
				LoginRespDto resDto = new LoginRespDto();
				resDto.setEmail(login.getEmail());
				resDto.setRole(login.getRole());
				resDto.setLoggedIn(login.isLoggedIn());
			
				return resDto;
				
			} else {
				throw new InvalidCredentialsException("Invalid credentials!");
			}
		} else {
			// throw exception if given email not present in the db.
			throw new InvalidCredentialsException("User not found with email: "+loginDto.getEmail());
		}
	
	}

	@Override
	public LoginRespDto logout(String email) throws EmailNotFoundException {
		
		Optional<Login> dbLoginOpt = loginRepo.findById(email);
		if(dbLoginOpt.isPresent()) {
			// update isLoggedIn flag as false and save
			Login login = dbLoginOpt.get();
			
			// Update flag to false and save
			login.setLoggedIn(false);
			Login updatedLogin = loginRepo.save(login);
			
			// Convert Login obj to LoginRespDto
			LoginRespDto resDto = new LoginRespDto();
			
			resDto.setLoggedIn(false);
					
			// return LoginRespDto obj
			return resDto;
		} else {
			throw new EmailNotFoundException("User not found with email: "+email);
		}
	}

}
