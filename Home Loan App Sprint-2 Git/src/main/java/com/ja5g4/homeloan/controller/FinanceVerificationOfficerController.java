package com.ja5g4.homeloan.controller;

import java.util.List;   
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.FinanceVerificationException;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.FinanceVerificationService;
import com.ja5g4.homeloan.service.ILoanApplicationService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/* Finance Verification Officer Service REST Controller
 * Finance Verification Officer Service
 * IFinanceVerificationService checks for the existing of loan application and 
 * other field as per necessity if existing
 *
 * Author : Gaurav Shrivastava 
 * */

@RestController
@RequestMapping("/financeverify")
@ApiModel(value="Finance Verification Controller", description = "Holds all APIs related to the Finanace")

public class FinanceVerificationOfficerController {
	Logger logger = Logger.getLogger(FinanceVerificationOfficerController.class.getName());
	
	@Autowired
	FinanceVerificationService financeVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	public FinanceVerificationOfficerController() {
		logger.log(Level.INFO,"-----> Finance Officer Rest Controller Working!");
		
	}
	
	@ApiOperation(value="GET mapping for the Finance Verification to update the status of application",response=List.class)
	@GetMapping("/allloanapplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@ApiOperation(value="PUT mapping for the Finance Verification to update the status of application",response=FinanceVerificationOfficerController.class)
	@PutMapping("/updatefinanceverificationstatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateFinanceStatus(@PathVariable int loanApplicationId) throws FinanceVerificationException, InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.updateFinanceStatus(loanApplicationId), HttpStatus.OK);

	}
	

	
	@ApiOperation(value="GET mapping for the Finance Verification to update the status of application",response=Boolean.class)
	@GetMapping("/validatingfinanceofficer/{username}/{password}")
	public ResponseEntity<Boolean> isValidFinanceOfficer(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(financeVerificationService.isValidFinanceOfficer(username, password),HttpStatus.OK);
	}

}
// By Gaurav Shrivastava 