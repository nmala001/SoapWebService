package com.nandithmalapati.spring.soap.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages= {"com.nandithmalapati.spring.soap.api.endpoint",
			      "com.nandithmalapati.spring.soap.api.loaneligibility",
			      "com.nandithmalapati.spring.soap.api.config",
			      "com.nandithmalapati.spring.soap.api.service",
			      "com.nandithmalapati.spring.soap.api"})
public class SpringBootSoapWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapWsApplication.class, args);
	}
}
