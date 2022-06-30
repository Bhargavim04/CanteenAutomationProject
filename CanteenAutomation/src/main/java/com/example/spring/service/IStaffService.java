package com.example.spring.service;

import com.example.spring.entity.Staff;
import com.example.spring.exception.AdminNotFoundException;
import com.example.spring.exception.StaffNotFoundException;

public interface IStaffService {
	Staff addStaff(Staff staff);

	Staff deleteStaff(int staffId) throws StaffNotFoundException;
    Staff getStaffById(int staffId)throws StaffNotFoundException;

	Staff updateStaff(int staffId, String staffname)throws StaffNotFoundException;



	



}

