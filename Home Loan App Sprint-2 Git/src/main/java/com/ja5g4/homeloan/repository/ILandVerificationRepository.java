package com.ja5g4.homeloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;  

import com.ja5g4.homeloan.entities.LandVerificationOfficer;

public interface ILandVerificationRepository extends JpaRepository<LandVerificationOfficer, Integer> {

	public LandVerificationOfficer findByUsernameAndPassword(String username, String password);

}


