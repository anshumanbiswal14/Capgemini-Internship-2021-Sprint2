package com.ja5g4.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.repository.ILandVerificationRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;

@Service
public class LandVerificationService implements ILandVerificationService {

	@Autowired
	ILoanApplicationRepository loanApplicationRepository;
	
	@Autowired
	ILandVerificationRepository iLandVerificationRepository;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	// saving a specific record by using the method save() of CrudRepository
	public LandVerificationOfficer addLandOfficer(LandVerificationOfficer officer) {
		iLandVerificationRepository.save(officer);
		return officer;
	}	
	
	/*
	 * it checks whether the officer's credential is valid or not
	 * it returns true or false
	 */
	@Override
	public Boolean isValidLandOfficer(String userName, String password) {
		return iLandVerificationRepository.findByUsernameAndPassword(userName, password)!=null;
	}
}