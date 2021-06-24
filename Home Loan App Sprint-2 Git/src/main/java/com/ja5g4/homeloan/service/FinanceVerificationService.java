package com.ja5g4.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;  

import org.springframework.stereotype.Service;
import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;
import com.ja5g4.homeloan.repository.IFinanceVerificationRepository;

/*Finance Verification Officer Service
 *IFinanceVerificationService checks for the existing of loan application and 
 *other field as per necessity if existing
 *
 * Author : Gaurav Shrivastava 
 * */

@Service
public class FinanceVerificationService implements IFinanceVerificationService {

	@Autowired
	IFinanceVerificationRepository iFinanceVerificationRepository;
	
	// saving a specific record by using the method save() of CrudRepository
	public FinanceVerificationOfficer addFinanceOfficer(FinanceVerificationOfficer officer) {
		iFinanceVerificationRepository.save(officer);
		return officer;
	}

	/*
	 * it checks whether the ofiicer's credential is valid or not
	 * it returns true or false
	 */
	@Override
	public Boolean isValidFinanceOfficer(String username, String password) {
		return iFinanceVerificationRepository.findByUsernameAndPassword(username, password)!=null;
	}
	
}
//By Gaurav Shrivastava 