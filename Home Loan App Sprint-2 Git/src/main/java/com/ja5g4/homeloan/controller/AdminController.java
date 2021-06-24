package com.ja5g4.homeloan.controller;

import java.time.LocalDate; 
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

/* Admin REST Controller
 * Admin Controller contains various methods to interact with the loan user table
 * "/addAdmin" is to add admin to the user table
 * "/addLandOfficer" to add land officer to the user table
 * "/addFinanceOfficer" to add finance officer to the user table
 * "/viewadmin/{userId}" to view customer by id
 * "/viewalladmins" to view all the admins
 * "/viewallcustomers" to view all the customers
 * "/allloanapplications" to get the list of all loan applications
 * "/allloanagreements" to get all the loan agreements
 * "/validatingadmin/{username}/{password}" to validate the username of admin
 * "/deletecustomer/{userId}" to delete the customer by using the userID
 * "/deleteloanapplication/{loanApplicationId}" delete loan applications
 * "/deleteloanagreement/{loanAgreementId}" delete loan agreement 
 * "/viewbydate/{date}" to view by loan application date
 * 
 * Author : Blesy Helen
 * */

@Validated
@RestController
@RequestMapping("/admin")
@ApiModel(value = "Admin Service Rest Controller" , description = "Holds all APIs related to the Admin Service")

public class AdminController {

	Logger logger = Logger.getLogger(AdminController.class.getName());	
	
	public AdminController() {
		logger.log(Level.INFO,"-----> Inside Admin Service Controller Working!");
	}
	
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
	
	@ApiOperation(value = "POST mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@PostMapping("/addadmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.OK);
	}
	
	@ApiOperation(value = "POST mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@PostMapping("/addfinanceofficer")
	public ResponseEntity<FinanceVerificationOfficer> addFinanceOfficer(@RequestBody @Valid FinanceVerificationOfficer officer) {
		return new ResponseEntity<>(financeVerificationService.addFinanceOfficer(officer), HttpStatus.OK);
	}
	
	@ApiOperation(value = "POST mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@PostMapping("/addlandofficer")
	public ResponseEntity<LandVerificationOfficer> addLandOfficer(@RequestBody @Valid LandVerificationOfficer officer) {
		return new ResponseEntity<>(landVerificationService.addLandOfficer(officer),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@GetMapping("/viewadmin/{userId}")
	public ResponseEntity<Admin> viewAdmin(@PathVariable("userId") int userId) {
		return new ResponseEntity<>(adminService.getAdmin(userId), HttpStatus.OK);
	}
	@ApiOperation(value = "GET mapping to add new user as admin to the LOAN_USER table in the Database", response = List.class)
	@GetMapping("/viewalladmins")
	public ResponseEntity<List<Admin>> viewAllAdmin() {
		return new ResponseEntity<>(adminService.getAllAdmin(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new user as admin to the LOAN_USER table in the Database", response = List.class)
	@GetMapping("/viewallcustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new user as admin to the LOAN_USER table in the Database", response = List.class)
	@GetMapping("/allloanapplications")
	public ResponseEntity<List<LoanApplication>> getAllLoanApplications() {
		return new ResponseEntity<>(loanApplicationService.getAllLoanApplication(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new user as admin to the LOAN_USER table in the Database", response = List.class)
	@GetMapping("/allloanagreements")
	public ResponseEntity<List<LoanAgreement>> getAllAgreementList() {
		return new ResponseEntity<>(loanAgreementService.getAllLoanAgreements(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "PUT mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@PutMapping("/updateadminverificationstatus/{loanApplicationId}")
	public ResponseEntity<LoanApplication> updateAdminStatus(@PathVariable int loanApplicationId) throws AdminApprovalException, InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.updateAdminStatus(loanApplicationId), HttpStatus.OK);

	}
	
	@ApiOperation(value = "PUT mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@PutMapping("/updateloanapplication")
	public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable int loanApplicationId, @RequestBody @Valid LoanApplication loanApplication) throws InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.updateLoanApplication(loanApplicationId,loanApplication), HttpStatus.OK);
	}
	
	@ApiOperation(value = "PUT mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@PutMapping("/updateloanagreement")
	public ResponseEntity<LoanAgreement> updateLoanAgreement(@PathVariable int loanAgreementId,@RequestBody @Valid LoanAgreement loanAgreement) throws InvalidLoanAgreementException {
		return new ResponseEntity<>(loanAgreementService.updateLoanAgreement(loanAgreementId, loanAgreement), HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@GetMapping("/validatingadmin/{username}/{password}")
	public ResponseEntity<Boolean> isValidAdmin(@PathVariable String username,@PathVariable String password) {
		return new ResponseEntity<>(adminService.isValidAdmin(username, password),HttpStatus.OK);
	}
	
	@ApiOperation(value = "DELETE mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@DeleteMapping("/deletecustomer/{userId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int userId) throws CustomerNotFoundException{
		return new ResponseEntity<>(customerService.deleteCustomer(userId),HttpStatus.OK);
	}
	
	@ApiOperation(value = "DELETE mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@DeleteMapping("/deleteloanapplication/{loanApplicationId}")
	public ResponseEntity<LoanApplication> deleteLoanApplication(@PathVariable int loanApplicationId) throws InvalidLoanApplicationException {
		return new ResponseEntity<>(loanApplicationService.deleteLoanApplication(loanApplicationId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "DELETE mapping to add new user as admin to the LOAN_USER table in the Database", response = Admin.class)
	@DeleteMapping("/deleteloanagreement/{loanAgreementId}")
	public ResponseEntity<LoanAgreement> deleteLoanAgreement(@PathVariable int loanAgreementId) throws InvalidLoanAgreementException {
		return new ResponseEntity<>(loanAgreementService.deleteLoanAgreement(loanAgreementId), HttpStatus.OK);
	}
	
	@ApiOperation(value = "GET mapping to view all customers by date of application", response = List.class )
	@GetMapping("/viewbydate/{date}")
	public List<Customer> viewCustomerApplicationList(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateOfApplication){
		return this.viewCustomerApplicationList(dateOfApplication);
		
	}

}
//By Blesy Helen