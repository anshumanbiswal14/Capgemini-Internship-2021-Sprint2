package com.ja5g4.homeloan.repository;
import org.springframework.data.jpa.repository.JpaRepository;  

import com.ja5g4.homeloan.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{
		

	public Admin findByUsernameAndPassword(String username, String password);
}