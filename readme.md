### Project Description

This code sample is an application that demonstrate how microservices applications are developed and deployed in containerized environment. 

### Detailed Description

Distributed Microservices are as below : 
-	Eurka discovery service
-	Movie-catalog-serivce
-	Movie-info-service
-	Ratings-data-service 

When Users try to call to find out any information ratings that they have provided, all these services work together to provide required information to users. movie-catalog-service make call to ratings-data-serivice to get user ratings. movie-catalog-service make call to movie-info-service to retrieve full information about movie from OMDB API (http://www.omdbapi.com). Response from both services aggregated and sent to caller. If one of this call fails, hystrix provides resilience mechanism. All the services registers with Spring Cloud Eureka before joining the cluster. 

### Aim for project : 
End to End microservices Architecture with 
 - [x] proper Decomposition
 - [x] Communication
 - [x] Circuit Breaking
 - [x] Testing and Deployment
 - [x] Documentation of development
 - [ ] Security
 - [ ] Observability

### Dependencies
I will update the dependencies as needed. 
 - [x] git
 - [x] JDK 1.8
 - [x] maven
 - [x] Docker
 - [ ] Kubernets

### Directory Structure

```
imdb-microservices
    ├───discovery-server
    │   
    ├───movie-catalog-service
    │   
    ├───movie-info-service
    │
    └───ratings-data-service
```
 Sample Service looks like below
 ```
 └───ratings-data-service
    ├───src    
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───imdb
    │   │   │           └───ratingsdataservice
    │   │   │               ├───models
    │   │   │               └───resources
    │   │   └───resources
    │   └───test
    │       └───java
    │           └───com
    │               └───imdb
    │                   └───ratingsdataservice
    └───target
        ├───ratings-data-service
            ├───config
            └───supported-libs
            ├─── ratings-data-service.jar 
```

### Clone project and setting up environment

  

-  ```git clone https://github.com/jeetmpatel1/imdb-microservices.git;```

-  ```yum install maven;```

### Clean Project
- Linux ( CentOS)
```
cd imdb-microservices;cd ./discovery-server;mvn clean; cd ..;cd ./movie-catalog-service;mvn clean;cd ..;cd ./ratings-data-service;mvn clean;cd ..; cd ./movie-info-service;mvn clean;cd ..;
```
- Windows Powershell
```
cd .\discovery-server;mvn clean; cd ..;cd .\movie-catalog-service;mvn clean;cd ..;cd .\ratings-data-service;mvn clean;cd ..; cd .\movie-info-service;mvn clean;cd ..;
```
### Build all Projects
- Linux ( CentOS )
```
cd ./discovery-server;mvn clean install; cd ..;cd ./movie-catalog-service;mvn clean install;cd ..;cd ./ratings-data-service;mvn clean install;cd ..; cd ./movie-info-service;mvn clean install;cd ..;
```
  
- Windows Powershell
```
cd .\discovery-server;mvn clean install; cd ..;cd .\movie-catalog-service;mvn clean install;cd ..;cd .\ratings-data-service;mvn clean install;cd ..; cd .\movie-info-service;mvn clean install;cd ..;
```
  
  

### Run all Projects

- Linux ( CentOS )
```
>java -jar ./discovery-server/target/discovery-server/discovery-server-1.0.jar;
java -jar ./movie-catalog-service/target/movie-catalog-service/movie-catalog-service-1.0.jar;
java -jar ./movie-info-service/target/movie-info-service/movie-info-service-1.0.jar;
java -jar ./ratings-data-service/target/ratings-data-service/ratings-data-service-1.0.jar;
```
- Windows Powershell
```
java -jar .\discovery-server\target\discovery-server\discovery-server-1.0.jar;
java -jar .\movie-catalog-service\target\movie-catalog-service\movie-catalog-service-1.0.jar;
java -jar .\movie-info-service\target\movie-info-service\movie-info-service-1.0.jar;
java -jar .\ratings-data-service\target\ratings-data-service\ratings-data-service-1.0.jar;
```
  
### Important URLs to access services

  

-	Discovery Server :

	>http://localhost:8761/

  

-	Movie Catalog Service :

	>http://localhost:8081/movie-catalog/status
	>http://localhost:8081/movie-catalog/users/2 {userId}
	
-	Movie Info Service:

	>http://localhost:8082/movie-info/status
	>http://localhost:8082/movie-info/movie/1 {movieId}

  

-	Ratings Data Services :

	>http://localhost:8083/ratings-data/status
	>http://localhost:8083/ratings-data/1 {movieId}
	>http://localhost:8083/ratings-data/users/2 {userId}

### Commands to kill running services
- Windows Powershell
```
Stop-Process -Id (Get-NetTCPConnection -LocalPort 8081).OwningProcess -Force
Stop-Process -Id (Get-NetTCPConnection -LocalPort 8082).OwningProcess -Force
Stop-Process -Id (Get-NetTCPConnection -LocalPort 8083).OwningProcess -Force
Stop-Process -Id (Get-NetTCPConnection -LocalPort 8761).OwningProcess -Force
```