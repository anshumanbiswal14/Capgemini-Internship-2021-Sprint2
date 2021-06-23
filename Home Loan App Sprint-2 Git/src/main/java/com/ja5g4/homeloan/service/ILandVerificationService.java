package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;

/*Land Verification Officer Service
 *ILandVerificationService checks for the existing of loan application and updates the status and 
 *ILandVerificationService isValidLandOfficer(String username, String password) validate LandVerificationOfficer
 *ILandVerificationService addLandOfficer(LandVerificationOfficer officer) add LandVerificationOfficer
 * Author : Gaurav Shrivastava 
 * */

public interface ILandVerificationService {
	
	public Boolean isValidLandOfficer(String username, String password);
	public LandVerificationOfficer addLandOfficer(LandVerificationOfficer officer); 
}


