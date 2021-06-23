package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;

public interface IFinanceVerificationService  {
	
	public Boolean isValidFinanceOfficer(String username, String password);
	public FinanceVerificationOfficer addFinanceOfficer(FinanceVerificationOfficer officer); 

}
