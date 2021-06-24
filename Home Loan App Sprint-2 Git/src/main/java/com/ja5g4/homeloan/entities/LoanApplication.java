package com.ja5g4.homeloan.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.FutureOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "loan_application")
@ApiModel(value = "Loan Application Bean Class")

public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(name = "Loan application ID", value = "It holds the loan application ID", required = true)
	private int applicationId;
	
	@ApiModelProperty(name = "Loan application date", value = "It holds the loan application date", required = true)
	@FutureOrPresent
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column
	private LocalDate applicationDate;  
		
	@OneToOne
	@ApiModelProperty(name = "Customer", value = "It holds the customer information", required = true)
	private Customer customer;
	
	@ApiModelProperty(name = "Loan applied amount", value = "It holds the loan applied amount", required = true)
	@DecimalMin(value = "0", message = "Loan applied amount should not be less than thousand values")
	@Column
	private double loanAppliedAmount;
	
	@ApiModelProperty(name = "Loan tenure years", value = "It holds the tenture date information", required = true)
	@Column
	private int loanTenureYears;
	
	@ApiModelProperty(name = "Loan approved amount", value = "It holds the loan approved amount", required = true)
	@DecimalMin(value = "0", message = "Loan approved amount should not be less than thousand values")
	@Column
	private double loanApprovedAmount;
	
	@ApiModelProperty(name = "Land Verification approval status", value = "It holds the admin approval status", required = true)
	@Column
	private boolean landVerificationApproval;
	
	@ApiModelProperty(name = "Finance Verification approval status", value = "It holds the admin approval status", required = true)
	@Column
	private boolean financeVerificationApproval;
	
	@ApiModelProperty(name = "Admin approval status", value = "It holds the admin approval status", required = true)
	@Column
	private boolean adminApproval;
	
	@Enumerated(EnumType.STRING)
	@ApiModelProperty(name = "Status ENUM", value = "It holds the status", required = true)
	@Column
	private Status status;

	public LoanApplication() {
		super();
	}
	
	public LoanApplication(int applicationId, LocalDate applicationDate, Customer customer, double loanAppliedAmount,
			int loanTenureYears, double loanApprovedAmount, boolean landVerificationApproval,
			boolean financeVerificationApproval, boolean adminApproval, Status status) {
		super();
		this.applicationId = applicationId;
		this.applicationDate = applicationDate;
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanTenureYears = loanTenureYears;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}



	public LoanApplication(Customer customer, double loanAppliedAmount, int loanTenureYears) {
		super();
		this.customer = customer;
		this.loanAppliedAmount = loanAppliedAmount;
		this.applicationDate=LocalDate.now();
		this.loanTenureYears=loanTenureYears;
		this.landVerificationApproval = false;
		this.financeVerificationApproval = false;
		this.adminApproval=false;
		this.status = Status.WAITING_FOR_LAND_VERIFICATION_OFFICE_APPROVAL;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public int getLoanTenureYears() {
		return loanTenureYears;
	}

	public void setLoanTenureYears(int loanTenureYears) {
		this.loanTenureYears = loanTenureYears;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public boolean isFinanceVerificationApproval() {
		return financeVerificationApproval;
	}

	public void setFinanceVerificationApproval(boolean financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}

	public boolean isAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", applicationDate=" + applicationDate
				+ ", customer=" + customer + ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount="
				+ loanApprovedAmount + ", landVerificationApproval=" + landVerificationApproval
				+ ", financeVerificationApproval=" + financeVerificationApproval + ", adminApproval=" + adminApproval
				+ ", status=" + status + "]";
	}

}
//By Blesy Helen