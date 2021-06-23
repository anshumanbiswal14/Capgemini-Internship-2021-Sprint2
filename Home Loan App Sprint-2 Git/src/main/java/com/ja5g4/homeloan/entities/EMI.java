package com.ja5g4.homeloan.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "EMI Bean Class")
@Table(name = "emi")
public class EMI {

	@ApiModelProperty(name = "EMI ID", value = "holding EMI ID", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long EMIId;
	
	@Column
	@ApiModelProperty(name = "Due Date", value = "It holds the Due Date", required = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dueDate;
	
	@Column
	@ApiModelProperty(name = "EMI Amount", value = "It holds the EMI Amount", required = true)
	@DecimalMin(value = "0", message = "Emi should not be zero")
	private double emiAmount;
	
	@Column
	@ApiModelProperty(name = "Loan Amount", value = "It holds the Loan Amount", required = true)
	@DecimalMin(value = "0", message = "Loan should not be zero")
	private double loanAmount;
	
	@Column
	@ApiModelProperty(name = "Interest Amount", value = "It holds the Interest Amount", required = true)
	@DecimalMin(value = "0", message = "Interest should not be zero")
	private double interestAmount;

	public EMI() {
		super();
	}

	public EMI(long eMIId, LocalDate dueDate, double emiAmount, double loanAmount, double interestAmount) {
		super();
		EMIId = eMIId;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
		this.loanAmount = loanAmount;
		this.interestAmount = interestAmount;
	}

	public long getEMIId() {
		return EMIId;
	}

	public void setEMIId(long eMIId) {
		EMIId = eMIId;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public double getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	@Override
	public String toString() {
		return "EMI [EMIId=" + EMIId + ", dueDate=" + dueDate + ", emiAmount=" + emiAmount + ", loanAmount="
				+ loanAmount + ", interestAmount=" + interestAmount + "]";
	}

}
