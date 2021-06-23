package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.EMI;

/*IEmiService
* IEmiService EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure)
* IEmiService calculateEmi(double principal,double intrestRate,int tenure) to calculate Emi
* 
*/
public interface IEmiService {

	public EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure); 
	public double calculateEmi(double principal,double intrestRate,int tenure);
	
}