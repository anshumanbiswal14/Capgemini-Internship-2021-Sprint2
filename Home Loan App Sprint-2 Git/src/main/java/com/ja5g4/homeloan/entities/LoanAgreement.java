package com.ja5g4.homeloan.entities;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "loan_agreement")
@ApiModel(value = "Loan Agreement Bean Class")
public class LoanAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "Loan Agreement ID", value = "It holds the loan agreement ID", required = true)
	private int loanAgreementId;

	@ApiModelProperty(name = "Loan Application ID", value = "It holds the loan application ID", required = true)
	@Column
	private int loanApplicationId;

	@OneToOne
	@ApiModelProperty(name = "EMIs for Loan Agreement", value = "It holds all EMIs linked to Loan Agreement", required = true)
	private EMI emi;

	public LoanAgreement() {
		super();
	}

	public LoanAgreement(int loanAgreementId, int loanApplicationId, EMI emi) {
		super();
		this.loanAgreementId = loanAgreementId;
		this.loanApplicationId = loanApplicationId;
		this.emi = emi;
	}
	
	public LoanAgreement(int loanApplicationId, EMI emi) {
		super();
		this.loanApplicationId = loanApplicationId;
		this.emi = emi;
	}

	public int getLoanAgreementId() {
		return loanAgreementId;
	}

	public void setLoanAgreementId(int loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}

	public int getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(int loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public EMI getEmi() {
		return emi;
	}

	public void setEmi(EMI emi) {
		this.emi = emi;
	}

	@Override
	public String toString() {
		return "LoanAgreement [loanAgreementId=" + loanAgreementId + ", loanApplicationId=" + loanApplicationId
				+ ", emi=" + emi + "]";
	}

}
// By Bharath Surya