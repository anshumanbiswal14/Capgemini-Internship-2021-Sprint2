package com.ja5g4.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;  

import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;

public interface IFinanceVerificationRepository extends JpaRepository<FinanceVerificationOfficer, Integer>{


	public FinanceVerificationOfficer findByUsernameAndPassword(String username, String password);
}
