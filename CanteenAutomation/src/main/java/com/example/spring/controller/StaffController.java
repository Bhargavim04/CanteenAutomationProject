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

import com.example.spring.entity.Staff;
import com.example.spring.exception.StaffNotFoundException;
import com.example.spring.service.IStaffService;


@RestController
public class StaffController {
	private static final String StaffId = null;
	@Autowired
	IStaffService staffServ;

	@PostMapping("/staff")
	ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
		Staff newStaff = staffServ.addStaff(staff);
		return new ResponseEntity<>(newStaff, HttpStatus.CREATED);
	}

	// get staff based on id
	@GetMapping("/staff{id}")
	ResponseEntity<Staff> getStaffById(@PathVariable("id") int staffId) throws StaffNotFoundException {
		Staff newstaff = staffServ.getStaffById(staffId);
		return new ResponseEntity<>(newstaff, HttpStatus.OK);
	}

// update staff
	@PatchMapping("/staff/name/{id}")
	ResponseEntity<Staff> updateStaffName(@PathVariable("id") int staffId, String staffname)
			throws StaffNotFoundException {
		Staff staff = staffServ.updateStaff(staffId, staffname);
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}

//delete Staff
	@DeleteMapping("/Staff/{id}")
	ResponseEntity<Staff> deleteStaff(@PathVariable("id") int staffId) throws StaffNotFoundException {
		Staff staff = staffServ.deleteStaff(staffId);
		return new ResponseEntity<>(staff, HttpStatus.OK);
	}

}
