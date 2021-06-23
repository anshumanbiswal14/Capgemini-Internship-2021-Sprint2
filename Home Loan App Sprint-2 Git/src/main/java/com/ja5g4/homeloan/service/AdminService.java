package com.ja5g4.homeloan.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.Admin;
import com.ja5g4.homeloan.repository.IAdminRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	IAdminRepository iAdminRepository;
	
	@Autowired
	ILoanApplicationRepository loanApplicationRepository;
	
	@Autowired
	ILoanApplicationService loanApplicationService;

	// saving a specific record by using the method save() of CrudRepository
	public Admin addAdmin(Admin admin) {
		iAdminRepository.save(admin);
		return admin;
	}

	// getting a specific record by using the method findById() of CrudRepository
	public Admin getAdmin(int userId) {
		return iAdminRepository.findById(userId).get();
	}

	// getting all Employee record by using the method findaAll() of CrudRepository
	public List<Admin> getAllAdmin() {
		return iAdminRepository.findAll();
	}
	
	/*
	 * this method check the admin's credential is valid or not
	 * it returns true or false
	 */
   
	@Override
	public Boolean isValidAdmin(String username, String password) {
		return iAdminRepository.findByUsernameAndPassword(username, password)!=null;
	}
	
}