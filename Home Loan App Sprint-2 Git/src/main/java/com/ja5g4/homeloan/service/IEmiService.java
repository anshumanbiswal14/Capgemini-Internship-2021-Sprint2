package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.EMI;

public interface IEmiService {

	public EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure); 
	public double calculateEmi(double principal,double intrestRate,int tenure);
	
}