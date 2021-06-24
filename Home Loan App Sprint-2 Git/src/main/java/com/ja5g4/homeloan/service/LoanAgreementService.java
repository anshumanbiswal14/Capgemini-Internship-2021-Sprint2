package com.ja5g4.homeloan.service;

import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.EMI;
import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.repository.ILoanAgreementRepository;

/* Loan Agreement Service
 * LoanAgreement addLoanAgreement(LoanAgreement loanAgreement) to add new loan agreement
 * LoanAgreement updateLoanAgreement(LoanAgreement loanAgreement) throws InvalidLoanAgreementException to update the loan agreement
 * LoanAgreement deleteLoanAgreement(long loanAgreementId) throws InvalidLoanAgreementException to delete the loan agreement
 * List<LoanAgreement> getAllLoanAgreement() to get all the loan agreement
 * LoanAgreement getLoanAgreement(long loanAgreementId)throws InvalidLoanAgreementException to get loan agreement by loan Id
 
 * Author : Bharath Surya 
 * */

@Service
public class LoanAgreementService implements ILoanAgreementService{

	@Autowired
	ILoanAgreementRepository loanAgreementRepository;
	
	// this method add LoanAgreement of specific loan application using LoanApplicationId
	@Override
	public LoanAgreement addLoanAgreement(int loanApplicationId, EMI emi) {
		LoanAgreement loanAgreement = new LoanAgreement(loanApplicationId,emi);
		return loanAgreementRepository.save(loanAgreement); 
	}
	
	// get the specific LoanAgreement using loanApplicationId
	@Override
	public LoanAgreement getLoanAgreement(int loanApplicationId) throws InvalidLoanAgreementException {
		return loanAgreementRepository.findByLoanApplicationId(loanApplicationId).orElseThrow(() -> new InvalidLoanAgreementException("Loan Agreement Not Found!"));
	}
		
	// for getting all the LoanAgreements 
	@Override
	public List<LoanAgreement> getAllLoanAgreements() {
		 return loanAgreementRepository.findAll();
	}
	
	// remove specific LoanAgreement using loanAgrrementId 
	@Override
	public LoanAgreement deleteLoanAgreement(int loanAgreementId) throws InvalidLoanAgreementException {
		LoanAgreement loanAgreement = getLoanAgreement(loanAgreementId);
		loanAgreementRepository.deleteById(loanAgreementId);
		return loanAgreement;
	}
	
	// update the info of specific LoanAgreement using loanAgreementId
	@Override
	public LoanAgreement updateLoanAgreement(int loanAgreementId, LoanAgreement loanAgreement)
			throws InvalidLoanAgreementException {
		loanAgreementRepository.findById(loanAgreementId)
				.orElseThrow(() -> new InvalidLoanAgreementException("Loan Agreement Not Found!"));
		return loanAgreementRepository.save(loanAgreement);
	}

}