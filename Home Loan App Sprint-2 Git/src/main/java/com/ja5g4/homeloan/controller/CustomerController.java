package com.ja5g4.homeloan.controller;

import java.util.logging.Level; 
import java.util.logging.Logger;

import javax.validation.Valid;

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

/* Customer Service REST Controller
 * ICustomerService implements the interface CustomerService
 * Customer addCustomer(Customer customer) to add new customer to table
 * Customer updateCustomer(int userId, Customer customer) throws CustomerNotFoundException to update customer details
 * Customer deleteCustomer(int userid) throws CustomerNotFoundException to delete customer using Id
 * Customer getCustomer(int userid) throws CustomerNotFoundException view customer by Id
 * List<Customer> getAllCustomers() to view all the customers in the table
 * Customer getUserIdByUsername(String username) throws exception if not found
 * Customer isValidCustomer(String username, String password) validate customer
 * 
 * Author : Anshuman Biswal
 * */

@Validated
@RestController
@RequestMapping("/customer")
@ApiModel(value = "Customer Service Rest Controller" , description = "Holds all APIs related to the Customer Service")

public class CustomerController {
	Logger logger = Logger.getLogger(CustomerController.class.getName());	
	
	public CustomerController() {
		logger.log(Level.INFO,"-----> Inside Customer Service Controller Working!");
	}
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ILoanApplicationService loanapplicationservice;
	
	@Autowired
	IEmiService emiService;
	
	boolean isLoggedIn = false;
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : Home Loan Application (Version 1.0)";
	}
	
	@ApiOperation(value = "POST mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@GetMapping("/getcustomer/{userId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable int userId) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.getCustomer(userId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@GetMapping("/getuserid/{username}")
	public ResponseEntity<Integer> getUserId(@PathVariable String username) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.getUserIdByUsername(username),HttpStatus.OK);
	}
	
	@ApiOperation(value = "PUT mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.OK);
	}
	
	@ApiOperation(value = "POST mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@PostMapping("/applyloan/{userId}/{loanAppliedAmount}/{loanTenureYears}")
	public ResponseEntity<LoanApplication> applyLoan(@PathVariable int userId, @PathVariable double loanAppliedAmount, @PathVariable int loanTenureYears) throws CustomerNotFoundException {
		return new ResponseEntity<>(loanapplicationservice.addLoanApplication(userId,loanAppliedAmount,loanTenureYears), HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@GetMapping("/loantracker/{loanApplicationId}")
	public ResponseEntity<Status> loanTracker(@PathVariable int loanApplicationId) throws InvalidLoanApplicationException{
		return new ResponseEntity<>(loanapplicationservice.getLoanApplication(loanApplicationId).getStatus(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@GetMapping("/loanagreement/{loanApplicationId}")
	public ResponseEntity<LoanAgreement> getLoanAgreement(@PathVariable int loanApplicationId) throws InvalidLoanAgreementException{
		return new ResponseEntity<>(loanapplicationservice.getLoanAgreement(loanApplicationId),HttpStatus.OK);
	}
	@ApiOperation(value = "GET mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@GetMapping("/EMIcalculator/{principal}/{intrestRate}/{tenure}")
	public ResponseEntity<?> emiCalculator(@PathVariable double principal,@PathVariable double intrestRate,@PathVariable int tenure){
		return new ResponseEntity<>(emiService.calculateEmi(principal, intrestRate, tenure),HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "GET mapping to add new customers to the LOAN_USER table in the Database", response = Customer.class)
	@GetMapping("/validatingcustomer/{username}/{password}")
	public boolean isValidCustomer(@PathVariable String username,@PathVariable String password) {
		if(customerService.isValidCustomer(username, password)) {
			isLoggedIn=true;
			return true;
		}else
			return false; 
	}

}
// By Anshuman Biswal