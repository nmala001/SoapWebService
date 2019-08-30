package com.nandithmalapati.spring.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nandithmalapati.spring.soap.api.client.SoapClient;
import com.nandithmalapati.spring.soap.api.loaneligibility.Acknowledgement;
import com.nandithmalapati.spring.soap.api.loaneligibility.CustomerRequest;

@EnableAutoConfiguration
@RestController
@SpringBootApplication
@ComponentScan(basePackages = {"com.nandithmalapati.spring.soap.api",
								"com.nandithmalapati.spring.soap.api.client",
								"com.nandithmalapati.spring.soap.api.config",
								"com.nandithmalapati.spring.soap.api.loaneligibility"})
public class SpringBootSoapWsClientApplication {
	
	
	@Autowired
	private SoapClient client;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		
		return client.getLoanStatus(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapWsClientApplication.class, args);
	}

}
