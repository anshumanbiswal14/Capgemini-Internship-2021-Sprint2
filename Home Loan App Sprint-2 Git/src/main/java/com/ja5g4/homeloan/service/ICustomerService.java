package com.ja5g4.homeloan.service;

import java.util.List; 

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;


/*Customer Service
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


public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(int userId, Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(int userId) throws CustomerNotFoundException;
	public Customer getCustomer(int userId) throws CustomerNotFoundException;
	public List<Customer> getAllCustomers();
	public int getUserIdByUsername(String username) throws CustomerNotFoundException;
	public boolean isValidCustomer(String username, String password);
}
