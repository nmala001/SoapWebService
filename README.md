# SoapWebService
Service to Check Loan Eligibility

Steps to run:

1. Run the Soap service provider on a specific port (Here set to 8555)
2. Soap Provider Endpoint is http://localhost:8555/ws/loanEligibility.wsdl
3. This service can be tested on SOAPUI

4. Run the Soap service Client on a another port (Here set to 9090)

5. Soap Client Endpoint is http://localhost:9090/getLoanStatus

6. Request Body Sample Request:

Method : Post

{
	"customerName": "John",
	"age": 50,
	"yearlyIncome": 60000,
	"creditScore": 650,
	"employmentMode": "Contract"
}

Request Body Sample Response:

{
    "isEligible": true,
    "approvedAmount": 30000,
    "criteriaMismatch": []
}

7. Request Body Sample Request 2:

Method : Post

{
	"customerName": "Mithun",
	"age": 28,
	"yearlyIncome": 30000,
	"creditScore": 250,
	"employmentMode": "Contract"
}

Request Body Sample Response:



{
    "isEligible": false,
    "approvedAmount": 0,
    "criteriaMismatch": ["Age should be between 30 and 60 years", 
                        "Yearly income should be greater than 50000",
                        "Credit Score should  be greater than 600"]
}


