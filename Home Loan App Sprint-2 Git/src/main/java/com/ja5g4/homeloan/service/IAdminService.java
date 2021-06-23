package com.ja5g4.homeloan.service;

import java.util.List; 

import com.ja5g4.homeloan.entities.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin); 
	public Admin getAdmin(int userId);
	public List<Admin> getAllAdmin();
	public Boolean isValidAdmin(String username, String password);
	}

