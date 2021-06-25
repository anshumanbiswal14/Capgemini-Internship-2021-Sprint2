package com.ja5g4.homeloan.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ja5g4.homeloan.entities.EMI;

public interface IEmiRepository extends JpaRepository<EMI, Integer>{
	
	@Query("Select e from EMI e ORDER BY e.emiAmount asc")
	List<EMI> viewByEMIAmountASC();
	
	@Query("Select e from EMI e ORDER BY e.emiAmount desc")
	List<EMI> viewByEMIAmountDESC();
	
	@Query("Select e from EMI e where e.dueDate = :date")
    List<EMI> dueDate(@Param("date") LocalDate date);
	
	@Query("Select e from EMI e ORDER BY e.interestAmount asc")
	List<EMI> interestAmountASC();
	
	@Query("Select e from EMI e ORDER BY e.interestAmount desc")
	List<EMI> interestAmountDESC();
    

}