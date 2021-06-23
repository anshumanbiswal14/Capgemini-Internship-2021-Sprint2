package com.ja5g4.homeloan.service;

import java.util.List;  

import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.AdminApprovalException;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;
import com.ja5g4.homeloan.exception.FinanceVerificationException;
import com.ja5g4.homeloan.exception.LandVerificationException;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;

public interface ILoanApplicationService  {
	
	public LoanApplication addLoanApplication(int userId, double loanAppliedAmount,int loanTenureYears) throws CustomerNotFoundException;
	
	public LoanApplication updateLoanApplication(int loanApplicationId,LoanApplication loanApplication) throws InvalidLoanApplicationException;
	public LoanApplication deleteLoanApplication(int loanApplicationId) throws InvalidLoanApplicationException;
	public List<LoanApplication> getAllLoanApplication();
	public LoanApplication getLoanApplication(int loanApplicationId) throws InvalidLoanApplicationException;
	public LoanApplication updateLandStatus(int loanApplicationId) throws LandVerificationException,InvalidLoanApplicationException;
	public LoanApplication updateFinanceStatus(int loanApplicationId) throws FinanceVerificationException, InvalidLoanApplicationException;
	public LoanApplication updateAdminStatus(int loanApplicationId) throws AdminApprovalException, InvalidLoanApplicationException;
	public LoanAgreement getLoanAgreement(int loanApplicationId)throws InvalidLoanAgreementException;
	

}
