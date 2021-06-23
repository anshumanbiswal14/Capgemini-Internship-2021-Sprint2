package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.entities.Status;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.CustomerService;
import com.ja5g4.homeloan.service.IEmiService;
import com.ja5g4.homeloan.service.ILoanApplicationService;

@RestController
@RequestMapping("/homeloan/customer")

public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ILoanApplicationService loanapplicationservice;
	
	@Autowired
	IEmiService emiService;
	
	boolean isLoggedIn = false;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
	}
	
	@GetMapping("/getCustomer/{userId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable int userId) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.getCustomer(userId),HttpStatus.OK);
	}
	
	@GetMapping("/getUserId/{username}")
	public ResponseEntity<Integer> getUserId(@PathVariable String username) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.getUserIdByUsername(username),HttpStatus.OK);
	}
	
	
	@PutMapping("/updateCustomer/{userId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int userId, @RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.updateCustomer(userId,customer),HttpStatus.OK);
	}
	
	@PostMapping("/applyLoan/{userId}/{loanAppliedAmount}/{loanTenureYears}")
	public ResponseEntity<LoanApplication> applyLoan(@PathVariable int userId, @PathVariable double loanAppliedAmount, @PathVariable int loanTenureYears) throws CustomerNotFoundException {
		return new ResponseEntity<>(loanapplicationservice.addLoanApplication(userId,loanAppliedAmount,loanTenureYears), HttpStatus.OK);
	}
	
	@GetMapping("/loanTracker/{loanApplicationId}")
	public ResponseEntity<Status> loanTracker(@PathVariable int loanApplicationId) throws InvalidLoanApplicationException{
		return new ResponseEntity<>(loanapplicationservice.getLoanApplication(loanApplicationId).getStatus(),HttpStatus.OK);
	}
	
	@GetMapping("/loanAgreement/{loanApplicationId}")
	public ResponseEntity<LoanAgreement> getLoanAgreement(@PathVariable int loanApplicationId) throws InvalidLoanAgreementException{
		return new ResponseEntity<>(loanapplicationservice.getLoanAgreement(loanApplicationId),HttpStatus.OK);
	}
	@GetMapping("/EMICalculator/{principal}/{intrestRate}/{tenure}")
	public ResponseEntity<?> emiCalculator(@PathVariable double principal,@PathVariable double intrestRate,@PathVariable int tenure){
		return new ResponseEntity<>(emiService.calculateEmi(principal, intrestRate, tenure),HttpStatus.OK);
	}
	
	//Validating the user
	@GetMapping("/validatingCustomer/{username}/{password}")
	public boolean isValidCustomer(@PathVariable String username,@PathVariable String password) {
		if(customerService.isValidCustomer(username, password)) {
			isLoggedIn=true;
			return true;
		}else
			return false; 
	}

}
