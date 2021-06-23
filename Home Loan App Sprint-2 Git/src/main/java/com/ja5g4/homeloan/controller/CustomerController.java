package com.ja5g4.homeloan.controller;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;


/*Customer Service REST Controller
 * Customer service controller contains various methods to interact with the loan user table
 * "/add" is to add new customer to the database
 * "/getcustomer/{user_id}" to view the customer details by using the customer ID
 * "/getuserid/{user_name}" to view the customer details by using the customer Name
 * "/updatecustomer" to update the customer details or make any specific changes to details
 * "/applyloan/{userId}/{loanAppliedAmount}/{loanTenureYears}" to apply loan by giving userId, loanAppliedAmount or loanTenureYears
 * "/loantracker/{loanApplicationId}" to track loan status by using laonApplicationId
 * "/loanagreement/{loanApplicationId}" to view loanagreement details by using loanApplicationId
 * "/EMIcalculator/{principal}/{intrestRate}/{tenure}" to view EMI by using principal, interestRate or tenure
 * "/validatingcustomer/{username}/{password}" to validate customer and return True or False

 * Author : Anshuman Biswal 
 * */

@Validated
@RestController
@RequestMapping("/homeloan/customer")
@ApiModel(value = "Customer Service Rest Controller" , description = "Holds all APIs related to the customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ILoanApplicationService loanapplicationservice;
	
	@Autowired
	IEmiService emiService;
	
	boolean isLoggedIn = false;
	
	Logger logger = Logger.getLogger(CustomerController.class.getName());
	public CustomerController() {
		logger.log(Level.INFO,"-----> Customer Rest Controller Working!");
		
	}

	@ApiOperation(value = "POST mapping to add new customers to the LOAN_Data table in the Database", response = Customer.class)
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to view customers by entering the customer ID", response = Customer.class )	
	@GetMapping("/getcustomer/{userId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable int userId) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.getCustomer(userId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to view customers by entering the customer Name", response = Customer.class )	
	@GetMapping("/getuserid/{username}")
	public ResponseEntity<Integer> getUserId(@PathVariable String username) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.getUserIdByUsername(username),HttpStatus.OK);
	}
	
	@ApiOperation(value = "PUT mapping to update customer details by customer ID", response = Customer.class )
	@PutMapping("/updatecustomer/{userId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int userId, @RequestBody Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.updateCustomer(userId,customer),HttpStatus.OK);
	}
	
	@ApiOperation(value = "POST mapping to applyloan by entering customer Id, LoanAppliedAmount and LoanTenureYears", response = Customer.class)
	@PostMapping("/applyloan/{userId}/{loanAppliedAmount}/{loanTenureYears}")
	public ResponseEntity<LoanApplication> applyLoan(@PathVariable int userId, @PathVariable double loanAppliedAmount, @PathVariable int loanTenureYears) throws CustomerNotFoundException {
		return new ResponseEntity<>(loanapplicationservice.addLoanApplication(userId,loanAppliedAmount,loanTenureYears), HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to track loan by entering the LoanAplicationId", response = Customer.class )	
	@GetMapping("/loantracker/{loanApplicationId}")
	public ResponseEntity<Status> loanTracker(@PathVariable int loanApplicationId) throws InvalidLoanApplicationException{
		return new ResponseEntity<>(loanapplicationservice.getLoanApplication(loanApplicationId).getStatus(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to view LoanAgreement by entering the LoanAplicationId", response = Customer.class )	
	@GetMapping("/loanagreement/{loanApplicationId}")
	public ResponseEntity<LoanAgreement> getLoanAgreement(@PathVariable int loanApplicationId) throws InvalidLoanAgreementException{
		return new ResponseEntity<>(loanapplicationservice.getLoanAgreement(loanApplicationId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to view EMI by entering the Principal, InterestRate and Tenure", response = Customer.class )	
	@GetMapping("/EMIcalculator/{principal}/{interestRate}/{tenure}")
	public ResponseEntity<?> emiCalculator(@PathVariable double principal,@PathVariable double intrestRate,@PathVariable int tenure){
		return new ResponseEntity<>(emiService.calculateEmi(principal, intrestRate, tenure),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to Validate Customer by entering the Username and Password", response = Customer.class )	
	//Validating the user
	@GetMapping("/validatingcustomer/{username}/{password}")
	public boolean isValidCustomer(@PathVariable String username,@PathVariable String password) {
		if(customerService.isValidCustomer(username, password)) {
			isLoggedIn=true;
			return true;
		}else
			return false; 
	}

}
