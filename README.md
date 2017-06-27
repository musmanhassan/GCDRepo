# Unico Programming Assignment

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Install Activemq

```
ActiveMq can be installed from the ActiveMq site http://activemq.apache.org/
```

### Project Technolgies used

The following technolgies were used for this assignment

1) Spring Boot
2) ActiveMq
3) H2DB for in memnory database
4) Apache Tomcat default with spring boot as application server
5) JPA for the persistence
6) Spring Security for securing the webservices

### Assignment Requirments met

1) Securing the SOAP and REST services
   This is done by spring security at application level by using basic authentication with user name and password
2) Scalibility and concurrent user access
    They Rest and Soap service methods are synchronized so concurrent access will not effect the behaviour.
3) GCD from head
   Queue are used which return the numbers from the head and move the pointer to the next element	

### REST Interface

1) Adding the numbers 
   URL:http://localhost:8080/gcd/v1/add
2) Getting all the numbers from database which are ever added to queue   
   URL:http://localhost:8080/gcd/v1/getAll
   
### SOAP Interface

1) Get the GCD 
   URL:http://localhost:8080/ws/webserviceGCD.xsd
   Sample Request:
   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://au.com.unico/gcd-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getGCDListRequest>
        
      </gs:getGCDListRequest>
   </soapenv:Body>
</soapenv:Envelope>
2)Get the GCD List which return the GCD from database   
   URL:http://localhost:8080/ws/webserviceGCD.xsd
   Sample Request:
   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://au.com.unico/gcd-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getGCDRequest>
        
      </gs:getGCDRequest>
   </soapenv:Body>
</soapenv:Envelope>

3) Get the GCD Sum which return the sum of GCD   
   URL:http://localhost:8080/ws/webserviceGCD.xsd
   Sample Request:
   <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://au.com.unico/gcd-service">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getGCDSumRequest>
        
      </gs:getGCDSumRequest>
   </soapenv:Body>
</soapenv:Envelope>
      
### Running the application

1) Use mvn spring-boot:run command to run the application at localhost:8080
2) Use the above REST and SOAP urls to access the application
3) Add the following information in the authentication header before sending the request to REST or SOAP service
   username:bill
   password:abc123

### Assumptions
In memory database and authintication was used for demonstration of this application but for the production physical database should be used like mysql
