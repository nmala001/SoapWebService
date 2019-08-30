package com.nandithmalapati.spring.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.nandithmalapati.spring.soap.api.loaneligibility.Acknowledgement;
import com.nandithmalapati.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class SoapClient {
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	
	private WebServiceTemplate template;
	
	
	public Acknowledgement getLoanStatus(CustomerRequest request) {
		
		template = new WebServiceTemplate(marshaller);
		Acknowledgement acknowledgment = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8555/ws", request);
		
		return acknowledgment;
	}
}
