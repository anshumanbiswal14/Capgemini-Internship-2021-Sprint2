package com.ja5g4.homeloan.repository;

import java.util.Optional;  

import org.springframework.data.jpa.repository.JpaRepository;
import com.ja5g4.homeloan.entities.LoanAgreement;

public interface ILoanAgreementRepository extends JpaRepository<LoanAgreement, Integer> {
	
	public Optional<LoanAgreement> findByLoanApplicationId(int loanApplicationId);
}
