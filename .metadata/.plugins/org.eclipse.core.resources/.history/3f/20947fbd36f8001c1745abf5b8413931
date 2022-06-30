package com.example.spring.controller;

import java.util.Optional;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springCore.entity.Login;
import com.example.springCore.service.ILoginService;

@RestController
public class LoginController {

    @Autowired
    ILoginService loginServ;

    @GetMapping("/login")
    public List<Login> getAllLogin() {
        return loginServ.getAllLogin();

    }

    @GetMapping("login/{email}")
    public Optional<Login> getLoginById(@PathVariable String email) {
        return loginServ.getLogin(email);
    }

    @PostMapping("login")
    public Login addLogin(@RequestBody Login Login) {
        return loginServ.addLogin(Login);
    }

    @PutMapping("login/{email}")
    public Login updateLogin(@PathVariable String email, @RequestBody Login Login) {
        return loginServ.updateLogin(email, Login);
    }

    @DeleteMapping("login/{email}")
    public Optional<Login> deleteLogin(@PathVariable String email) {
        return loginServ.deleteLogin(email);

    }
}*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Login;
import com.example.spring.service.ILoginService;

@RestController
public class LoginController {
	
	@Autowired
	ILoginService loginServ;

	@PostMapping("/login")
	ResponseEntity<Login> login(@RequestBody Login credentials) {
		Login login= loginServ.login(credentials);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
}