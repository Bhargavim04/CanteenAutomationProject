package com.example.spring.service;

import com.example.spring.entity.Admin;
import com.example.spring.exception.AdminNotFoundException;

public interface IAdminService {
	
	Admin addAdmin(Admin admin);
	Admin deleteAdmin(int adminId) throws AdminNotFoundException;
	Admin getAdminById(int adminId) throws AdminNotFoundException;
	Admin updateAdmin(Admin admin,  int adminId)throws AdminNotFoundException;  

}
