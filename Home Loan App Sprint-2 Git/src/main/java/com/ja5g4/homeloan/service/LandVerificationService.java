package com.ja5g4.homeloan.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.repository.ILandVerificationRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;

/*Land Verification Officer Service
 *LandVerificationService checks for the existing of loan application and updates the status
 *LandVerificationService addLandOfficer(LandVerificationOfficer officer) add Land Verification Officer
 *LandVerificationService isValidLandOfficer(String userName, String password)" to validate customer and return True or False
 * Author : Gaurav Shrivastava 
 * */

@Service
public class LandVerificationService implements ILandVerificationService {
	Logger logger = Logger.getLogger(LoanApplicationService.class.getName());
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