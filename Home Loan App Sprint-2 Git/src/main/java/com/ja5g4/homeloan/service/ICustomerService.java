package com.ja5g4.homeloan.service;

import java.util.List;  

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;

/*Customer Service
 * ICustomerServiceImpl implements the interface ICustomerService
 * Customer addCustomer(Customer customer) to add new customer to table
 * Customer getUserIdByUsername(String username) throws CustomerNotFoundException to update customer details
 * Customer getCustomer(int userId) throws CustomerNotFoundException
 * Customer getAllCustomer(int custid) throws CustomerNotFoundException view customer by Id
 * Customer updateCustomer(int userId,Customer customer) throws exception if not found
 * Customer deleteCustomer(int userId) throws CustomerNotFoundException if not found
 * isValidCustomer(String username, String password) validate customer
 * 
 * Author : Anshuman Biswal
 * */

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(int userId) throws CustomerNotFoundException;
	public Customer getCustomer(int userId) throws CustomerNotFoundException;
	public List<Customer> getAllCustomers();
	public int getUserIdByUsername(String username) throws CustomerNotFoundException;
	public boolean isValidCustomer(String username, String password);
}
//By Anshuman Biswal