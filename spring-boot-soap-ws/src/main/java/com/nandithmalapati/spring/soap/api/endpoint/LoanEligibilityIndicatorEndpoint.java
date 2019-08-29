package com.nandithmalapati.spring.soap.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nandithmalapati.spring.soap.api.loaneligibility.Acknowledgement;
import com.nandithmalapati.spring.soap.api.loaneligibility.CustomerRequest;
import com.nandithmalapati.spring.soap.api.service.LoanEligibilityService;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {
	
	private static final String NAMESPACE = "http://www.nandithmalapati.com/spring/soap/api/loanEligibility";
	
	//The service element has to be injected here
	
	@Autowired
	private LoanEligibilityService service;
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		
		return service.checkLoanEligibility(request);
		
	}
}
