package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.LandVerificationOfficer;

public interface ILandVerificationService {
	
	public Boolean isValidLandOfficer(String username, String password);
	public LandVerificationOfficer addLandOfficer(LandVerificationOfficer officer); 
}


