package com.example.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Staff;
import com.example.spring.exception.StaffNotFoundException;
import com.example.spring.repository.IStaffRepository;

@Service
public class StaffServiceImpl implements IStaffService {
	private static final Staff Staff = null;
	@Autowired
	IStaffRepository staffRepo;

	@Override
	public Staff addStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffRepo.save(staff);
	}

	@Override
	public Staff deleteStaff(int staffId) throws StaffNotFoundException {
		Optional<Staff> staff = staffRepo.findById(staffId);
		if (staff.isPresent()) {
			staffRepo.deleteById(staffId);
		} else {
			throw new StaffNotFoundException("Staff not found with staff id " + staffId);
		}
		return staff.get();

	}

	@Override
	public Staff getStaffById(int staffId) throws StaffNotFoundException {
		// TODO Auto-generated method stub
		Optional<Staff> staff = staffRepo.findById(staffId);
		if (staff.isPresent()) {
			return staff.get();
		} else {
			throw new StaffNotFoundException("Staff not found with staff id " + staffId);
		}
	}

	@Override
	public Staff updateStaff(int staffId, String staffname) throws StaffNotFoundException {
		Optional<Staff> staff = staffRepo.findById(staffId);
		if (staff.isPresent()) {
			Staff dbStaff = staff.get();
			dbStaff.setName(staffname);
			return staffRepo.save(dbStaff);
		} else {
			throw new StaffNotFoundException("Staff not found with staff id " + staffId);
		}
	}

}
