package com.ja5g4.homeloan.service;

import java.time.LocalDate; 
import java.util.List;

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.AdminApprovalException;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;
import com.ja5g4.homeloan.exception.FinanceVerificationException;
import com.ja5g4.homeloan.exception.LandVerificationException;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;

/* Loan Application Service
 * LoanApplicationService implements ILoanApplicationService interface
 * LoanApplication addLoanApplication(LoanApplication loanApplication) to add new loan application
 * LoanApplication updateLoanApplication(LoanApplication loanApplication) throws InvalidLoanApplicationException to update the loan application
 * LoanApplication deleteLoanApplication(long loanApplicationId) throws InvalidLoanApplicationException to delete the loan application
 * LoanApplication getLoanApplication(int loanApplicationId) throws InvalidLoanApplicationException
 * List<LoanApplication> getAllLoanApplication()
 * LoanAgreement getLoanAgreement(int loanApplicationId) throws InvalidLoanAgreementException
 * LoanApplication updateLandStatus(int loanApplicationId) throws LandVerificationException, InvalidLoanApplicationException
 * LoanApplication updateFinanceStatus(int loanApplicationId) throws FinanceVerificationException, InvalidLoanApplicationException
 * LoanApplication updateAdminStatus(int loanApplicationId) throws AdminApprovalException, InvalidLoanApplicationException
 * 
 * Author : Ashwin
 * */

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
//	public List<Customer> viewCustomerApplicationList(LocalDate dateOfApplication);

}
// By Ashwin