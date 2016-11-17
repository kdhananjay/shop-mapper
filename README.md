# shop-mapper
Shop-Mapper uses the Google Maps Geocoding API to retrieve  the longitude and latitude for the provided shopAddress. It also gets shops near to it based on the customerLongitude and customerLatitude.

# Two APIs

This Shop Mapper REST serviceprovides 2 APIs:-

  - (GET)Get all nearby shops based on longitude and latitude of customer.
  - (PPST)To add shop to Shop Mapper based on it's name and PostalCode.
  
 # Build
 
 Its usages Maven to build and packaging. use following commands

  - To build package using mvn. mvn clean package
  - Run mvn jar java -jar target/ShopMapper-0.0.1-SNAPSHOT.jar
 
 
 #Postman collection to test
    - ShopMapper.postman_collection.json added in the project to test the two APIs
    
 # Unit Testing
  Junit cases are in test folder to test the APIs code.
  
  #Design
  
  - Creating a RESTful Web Service with Spring Boot. 
  - Most of service/components have written as interface programming.
  - Rest Controller interacts with business service.
  - We have created a service class which interacts with Google geocode APIs and repository service (data layer).
  - Data layer has implemented as component as we have small operation, so not fully complaint with DTO/DAO pattern.
  
  # How to make it production ready?
  
  - Configuration for Dev/QA/Sandbox/Production/Common to help configure information like google API key used to access geocode data, or using DB connection or different rest-service(google geo code).
  - Pagination for long list of result-set.
  - Production build should have added Cobertura Code Coverage, Findbugs Reports.
  - complaint with commit/rollback/failover for transactions.
  - Caching : Most Recently Used(MRU) data should be cache as 20% of data reused 80% of time to save costly db operation.
  - Authentication: Allow only legitimate users to access the service.
  - Monitoring: Dashboard to have insights like success/failure/performance of APIs, usages of system, business value of system..
  - Error Handling : To provide logical HTTP status codes and message to the client.
  - Capacity and Performance : workout on business case about call per day and service response time.
  - Unit testing, functional testing and automation: This should cover all kind scenarios to handle error and exceptions.
  
  
  #Pending
  
  - Dashboard to monior the APIs
  - DataBase setup
  - APIs Documentaion.
