package com.example.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.entity.Admin;
import com.example.spring.exception.AdminNotFoundException;
import com.example.spring.repository.IAdminRepository;

import antlr.collections.List;

@Service
public class AdminServiceImpl implements IAdminService {
	private static final Admin Admin = null;
	@Autowired
	IAdminRepository adminRepo;

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}

	@Override
	public Admin deleteAdmin(int adminId) throws AdminNotFoundException {
		Optional<Admin> admin = adminRepo.findById(adminId);
		if (admin.isPresent()) {
			adminRepo.deleteById(adminId);
		} else {
			throw new AdminNotFoundException("Admin not found with admin id " + adminId);
		}
		return admin.get();

	}

	@Override
	public Admin getAdminById(int adminId) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminRepo.findById(adminId);
		if (admin.isPresent()) {
			return admin.get();
		} else {
			throw new AdminNotFoundException("Admin not found with admin id " + adminId);
		}
	}

	@Override
	public Admin updateAdmin(Admin admin, int adminId) {
		Optional<Admin> dbAdmin = adminRepo.findById(adminId);
		if (dbAdmin.isPresent()) {
			return adminRepo.save(admin);
		} else {
			return null;
		}
	}

}
