package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;

/*Finance Verification Officer Service
 *IFinanceVerificationService checks for the existing of loan application and 
 *other field as per necessity if existing
 *
 * Author : Gaurav Shrivastava 
 * */

public interface IFinanceVerificationService  {
	
	public Boolean isValidFinanceOfficer(String username, String password);
	public FinanceVerificationOfficer addFinanceOfficer(FinanceVerificationOfficer officer); 

}
//By Gaurav Shrivastava 