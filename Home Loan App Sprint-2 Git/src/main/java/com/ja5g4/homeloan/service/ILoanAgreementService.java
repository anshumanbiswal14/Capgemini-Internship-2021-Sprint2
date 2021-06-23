package com.ja5g4.homeloan.service;

import java.util.List;  

import com.ja5g4.homeloan.entities.EMI;
import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;

public interface ILoanAgreementService{
	
	public LoanAgreement addLoanAgreement(int loanApplicationId, EMI emi) ;
		
		public LoanAgreement updateLoanAgreement(int loanAgreementId, LoanAgreement loanAgreement) throws InvalidLoanAgreementException;
		public LoanAgreement deleteLoanAgreement(int loanAgreementId) throws InvalidLoanAgreementException;
		public List<LoanAgreement> getAllLoanAgreements();
		public LoanAgreement getLoanAgreement(int loanAgreementId) throws InvalidLoanAgreementException;
		
		




}
