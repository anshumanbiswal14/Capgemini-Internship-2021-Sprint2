package com.ja5g4.homeloan.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja5g4.homeloan.entities.EMI;
import com.ja5g4.homeloan.repository.IEmiRepository;

/* EmiService 
 * EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure) to add new EmiDetails to table
 * EMI calculateEmi(double principal,double intrestRate,int tenure) to calculate Emi
 * 
 * Author : Bharath Surya
 * */

@Service
public class EmiService implements IEmiService {
	
	Logger log = LoggerFactory.getLogger(EmiService.class);
	
	@Autowired
	IEmiRepository emiRepository;
	
	
	/*
	 * this method add emi details to the loan application when loan is approved
	 */
	@Override
	public EMI addEmiDetails(double loanAppliedAmount,double intrestRate,int tenure) {
		double emiAmount =calculateEmi(loanAppliedAmount,intrestRate,tenure);
		double loanAmount = emiAmount * 12 * tenure;
		EMI emi = new EMI();
		emi.setDueDate(LocalDate.now().plusYears(tenure));
		emi.setEmiAmount(emiAmount);
		emi.setLoanAmount(loanAmount);
		emi.setInterestAmount(loanAmount-loanAppliedAmount);
		
		return emiRepository.save(emi);
	}
	
	
	/*
	 * this method calculate the emi for customer
	 */
	@Override
	public double calculateEmi(double principal,double intrestRate,int tenure) {
		intrestRate = intrestRate/(12*100);
		tenure = 12 * tenure;
		return (principal * intrestRate * Math.pow(1 + intrestRate, tenure)) / (Math.pow(1 + intrestRate, tenure) - 1);
	}


	
	@Override
    public List<EMI> viewByEMIAmountASC() {
        List<EMI> EMIList = new ArrayList<>();
        try {
            EMIList = emiRepository.viewByEMIAmountASC();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return EMIList;

    }
	
	
	@Override
    public List<EMI> viewByEMIAmountDESC() {
        List<EMI> EMIList = new ArrayList<>();
        try {
            EMIList = emiRepository.viewByEMIAmountDESC();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return EMIList;

    }


	@Override
    public List<EMI> dueDate(LocalDate date) {

        List<EMI> sortedDate = new ArrayList<>();

        try {
            sortedDate = emiRepository.dueDate(date);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return sortedDate;
    }


	@Override
	public List<EMI> interestAmountASC() {
        List<EMI> InterestList = new ArrayList<>();
        try {
            InterestList = emiRepository.interestAmountASC();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return InterestList;

    }


	@Override
	public List<EMI> interestAmountDESC() {
        List<EMI> InterestList = new ArrayList<>();
        try {
            InterestList = emiRepository.interestAmountDESC();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return InterestList;

    }
}
// By Bharath Surya