package com.ja5g4.homeloan.service;

import java.time.LocalDate;
import java.util.List;

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
	List<EMI> viewByEMIAmountASC();
	List<EMI> viewByEMIAmountDESC();
	List<EMI> dueDate(LocalDate date);
	List<EMI> interestAmountASC();
	List<EMI> interestAmountDESC();
	
}
// By Bharath Surya