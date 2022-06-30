package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Admin;
import com.example.spring.exception.AdminNotFoundException;
import com.example.spring.service.IAdminService;

@RestController
public class AdminController {

	@Autowired
	IAdminService adminServ;

	@PostMapping("/admin")
	ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		Admin newAdmin = adminServ.addAdmin(admin);
		return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
	}

	// get admin based on id
	@GetMapping("/admin{id}")
	ResponseEntity<Admin> getAdminById(@PathVariable("id") int adminId) throws AdminNotFoundException {
		Admin newadmin = adminServ.getAdminById(adminId);
		return new ResponseEntity<>(newadmin, HttpStatus.OK);
	}

// update admin
	@PatchMapping("/admin{id}")
	ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @PathVariable("id") int adminId)
			throws AdminNotFoundException {
		Admin admin1 = adminServ.updateAdmin(admin, adminId);
		return new ResponseEntity<>(admin1, HttpStatus.OK);
	}

//delete Admin
	@DeleteMapping("/Admin/{id}")
	ResponseEntity<Admin> deleteAdmin(@PathVariable("id") int adminId) throws AdminNotFoundException {
		Admin admin = adminServ.deleteAdmin(adminId);
		return new ResponseEntity<>(admin, HttpStatus.OK);
	}

}
