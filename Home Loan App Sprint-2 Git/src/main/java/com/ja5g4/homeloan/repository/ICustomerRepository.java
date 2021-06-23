package com.ja5g4.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;  
import com.ja5g4.homeloan.entities.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByUsernameAndPassword(String username, String password);
	public Customer findByUsername(String username);
}
