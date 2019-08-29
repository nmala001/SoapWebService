package com.nandithmalapati.spring.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nandithmalapati.spring.soap.api.loaneligibility.Acknowledgement;
import com.nandithmalapati.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		
		//Creating the object of acknowledgment
		Acknowledgement acknowledgment = new Acknowledgement();
		List<String> mismatchCriteriaList = acknowledgment.getCriteriaMismatch();
		
		
		if(!(request.getAge() > 30 && request.getAge() <= 60)) {
			
			mismatchCriteriaList.add("Person age should be between 30 and 60");
			
		}
		
		if(!(request.getYearlyIncome() > 50000)) {
			
			mismatchCriteriaList.add("Minimum income should be more than 50000  USD");
			
		}
		
		if(!(request.getCreditScore() > 600)) {
			
			mismatchCriteriaList.add("Does not have the minimum cibil score");
			
		}
		
		if(mismatchCriteriaList.size()> 0) {
			
			acknowledgment.setApprovedAmount(0);
			acknowledgment.setIsEligible(false);
		}else {
			
			acknowledgment.setApprovedAmount(30000);
			acknowledgment.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		
		return acknowledgment;
	}
}
