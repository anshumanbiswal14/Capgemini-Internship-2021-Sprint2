package com.ja5g4.homeloan.controller;

import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.LandVerificationException;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.ILoanApplicationService;
import com.ja5g4.homeloan.service.LandVerificationService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;

/* Land Verification Officer REST Controller
 * Land Verification controller contain a two method to alter the loan application
 * "/LoanApplications" to view the Loan Applicant details
 * "/updateLandVerificationStatus/{loanApplicationId}"is a method to update the status of the loan application using LoanApplicationId 
 * "/validatingcustomer/{username}/{password}" to validate customer and return True or False
 * 
 * Author : Gaurav Shrivastava 
 * */

@Validated
@RestController
@RequestMapping("/homeloan/landOfficer")

public class LandVerificationOfficerController {

	@Autowired
	LandVerificationService landVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	Logger logger = Logger.getLogger(LandVerificationOfficerController.class.getName());
	//Method to check the working of land rest controller in the console
	public LandVerificationOfficerController() {
		logger.log(Level.INFO,"-----> Land Rest Controller Working!");
		
	}

	@ApiOperation(value="GET mapping to view the Loan Application Details ",response=LandVerificationOfficer.class)
	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@ApiOperation(value="PUT mapping for the Land Verification Officer to update the status of application by using LoanApplicationId",response=LandVerificationOfficer.class)
	@PutMapping("/updateLandVerificationStatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateLandStatus(@PathVariable int loanApplicationId) throws LandVerificationException, InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.updateLandStatus(loanApplicationId), HttpStatus.OK);

	}
	
	@ApiOperation(value = "GET mapping to Validate LandVerificationOfficer by entering the Username and Password", response = LandVerificationOfficer.class )	
	//Validating the user	
	@GetMapping("/validatingLandOfficer/{username}/{password}")
	public ResponseEntity<Boolean> isValidLandOfficer(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(landVerificationService.isValidLandOfficer(username, password),HttpStatus.OK);
	}

}
