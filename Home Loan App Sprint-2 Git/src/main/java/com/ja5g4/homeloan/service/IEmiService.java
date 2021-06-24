package com.ja5g4.homeloan.service;

import com.ja5g4.homeloan.entities.EMI;

/* EmiService 
 * EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure) to add new EmiDetails to table
 * EMI calculateEmi(double principal,double intrestRate,int tenure) to calculate Emi
 * 
 * Author : Bharath Surya
 * */

public interface IEmiService {

	public EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure); 
	public double calculateEmi(double principal,double intrestRate,int tenure);
	
}
// By Bharath Surya