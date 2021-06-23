package com.ja5g4.homeloan.controller;

import java.util.List;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja5g4.homeloan.entities.Admin;
import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.entities.FinanceVerificationOfficer;
import com.ja5g4.homeloan.entities.LandVerificationOfficer;
import com.ja5g4.homeloan.entities.LoanAgreement;
import com.ja5g4.homeloan.entities.LoanApplication;
import com.ja5g4.homeloan.exception.AdminApprovalException;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;
import com.ja5g4.homeloan.exception.InvalidLoanAgreementException;
import com.ja5g4.homeloan.exception.InvalidLoanApplicationException;
import com.ja5g4.homeloan.service.CustomerService;
import com.ja5g4.homeloan.service.IAdminService;
import com.ja5g4.homeloan.service.IFinanceVerificationService;
import com.ja5g4.homeloan.service.ILandVerificationService;
import com.ja5g4.homeloan.service.ILoanApplicationService;
import com.ja5g4.homeloan.service.LoanAgreementService;

@RestController
@RequestMapping("/homeloan/admin")

public class AdminController {

	@Autowired
	IAdminService adminService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	IFinanceVerificationService financeVerificationService;
	
	@Autowired
	ILandVerificationService landVerificationService;
	
	@Autowired
	ILoanApplicationService loanApplicationService;
	
	@Autowired
	LoanAgreementService loanAgreementService;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.OK);
	}
	
	@PostMapping("/addFinanceOfficer")
	public ResponseEntity<FinanceVerificationOfficer> addFinanceOfficer(@RequestBody FinanceVerificationOfficer officer) {
		return new ResponseEntity<>(financeVerificationService.addFinanceOfficer(officer), HttpStatus.OK);
	}
	
	@PostMapping("/addLandOfficer")
	public ResponseEntity<LandVerificationOfficer> addLandOfficer(@RequestBody LandVerificationOfficer officer) {
		return new ResponseEntity<>(landVerificationService.addLandOfficer(officer),HttpStatus.OK);
	}	
	
	@GetMapping("/{userId}")
	public ResponseEntity<Admin> viewAdmin(@PathVariable("userId") int userId) {
		return new ResponseEntity<>(adminService.getAdmin(userId), HttpStatus.OK);
	}
	
	@GetMapping("/Admins")
	public ResponseEntity<List<Admin>> viewAllAdmin() {
		return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.OK);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/LoanApplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@GetMapping("/LoanAgreements")
	public ResponseEntity<List<LoanAgreement>> getAllAgreementList() {
		return new ResponseEntity<>(loanAgreementService.getAllLoanAgreements(), HttpStatus.OK);
	}
	
	@PutMapping("/updateAdminVerificationStatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateAdminStatus(@PathVariable int loanApplicationId) throws AdminApprovalException, InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.updateAdminStatus(loanApplicationId), HttpStatus.OK);

	}
	
	@PutMapping("/updateLoanApplication")
	public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable int loanApplicationId, @RequestBody LoanApplication loanApplication) throws InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.updateLoanApplication(loanApplicationId,loanApplication), HttpStatus.OK);
	}
	
	@PutMapping("/updateLoanAgreement")
	public ResponseEntity<LoanAgreement> updateLoanAgreement(@PathVariable int loanAgreementId,@RequestBody LoanAgreement loanAgreement) throws InvalidLoanAgreementException {
		return new ResponseEntity<>(loanAgreementService.updateLoanAgreement(loanAgreementId, loanAgreement), HttpStatus.OK);
	}
	
	//Validating the user
	@GetMapping("/validatingAdmin/{username}/{password}")
	public ResponseEntity<Boolean> isValidAdmin(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(adminService.isValidAdmin(username, password),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomer/{userId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int userId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.deleteCustomer(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLoanApplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> deleteLoanApplication(@PathVariable int loanApplicationId) throws InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.deleteLoanApplication(loanApplicationId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteLoanAgreement/{loanAgreementId}")
	public ResponseEntity<LoanAgreement> deleteLoanAgreement(@PathVariable int loanAgreementId) throws InvalidLoanAgreementException {
		return new ResponseEntity<>(loanAgreementService.deleteLoanAgreement(loanAgreementId), HttpStatus.OK);
	}
	
}