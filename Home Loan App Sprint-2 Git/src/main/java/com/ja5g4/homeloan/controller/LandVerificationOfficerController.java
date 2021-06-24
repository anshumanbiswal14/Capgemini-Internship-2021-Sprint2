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
import com.ja5g4.homeloan.exception.LandVerificationException;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.ILoanApplicationService;
import com.ja5g4.homeloan.service.LandVerificationService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/* Land Verification Officer Service REST Controller
 * ILandVerificationService checks for the existing of loan application and updates the status and 
 * ILandVerificationService isValidLandOfficer(String username, String password) validate LandVerificationOfficer
 * ILandVerificationService addLandOfficer(LandVerificationOfficer officer) add LandVerificationOfficer
 * Author : Gaurav Shrivastava 
 * */

@RestController
@RequestMapping("/landverify")
@ApiModel(value="Land Verification Controller", description = "Holds all APIs related to the Land verification")

public class LandVerificationOfficerController {
	
	Logger logger = Logger.getLogger(LandVerificationOfficerController.class.getName());
	
	public LandVerificationOfficerController() {
		logger.log(Level.INFO,"-----> Land Officer Rest Controller Working!");
		
	}

	@Autowired
	LandVerificationService landVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	@GetMapping("/home")
	
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";	//returns the welcome home string value
	}

	@ApiOperation(value="GET mapping for the Land Verification to update the status of application",response=List.class)
	@GetMapping("/allloanapplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@ApiOperation(value="PUT mapping for the Land Verification to update the status of application",response=LandVerificationOfficerController.class)
	@PutMapping("/updatelandverificationstatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateLandStatus(@PathVariable int loanApplicationId) throws LandVerificationException, InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.updateLandStatus(loanApplicationId), HttpStatus.OK);

	}
	
	@ApiOperation(value="GET mapping for the Land Verification to update the status of application",response=Boolean.class)
	@GetMapping("/validatinglandofficer/{username}/{password}")
	public ResponseEntity<Boolean> isValidLandOfficer(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(landVerificationService.isValidLandOfficer(username, password),HttpStatus.OK);
	}

}
// By Gaurav Shrivastava 