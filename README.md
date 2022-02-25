A lot of time ago, for a job interview I have been asked to realize in a couple of days a register system. 
Since then I didn't touch this and don't plan to touch it in the future.

#Register System

## Project structure

The repository contains the following subdirectories:
- register-system-admin
  - It contains the frontend application written in React, it is a basic admin panel to list 
  all the users and delete one eventually.
- register-system-backend
  - It contains the backend application written in Java using Spring framework, it consist of 
  the endpoints for the admin panel and for a minimal REST service for user registration.
- register-system-data
  - It contains database schema with generated test data
- register-system-design
  - It contains some design documents like use case diagram, class diagrams, er diagram, and 
  mockups about the admin panel
- docker-compose.yaml file to run the project in the easiest way possible.
  
## How to start the project
### with Docker:
In case docker and docker-compose are available, it is suggested to run the project with them.
```text
* Open the terminal
* Set current directory to the project folder
* Run 'docker-compose up'
```
### without Docker:
```text
* In an instance of MySql database version 8+ run the script contained in the folder register-system-data
* In the folder register-system-backend:
  * find the file 'application.properties' and be sure to set the mysql connection parameters correctly.
  * run 'mvn spring-boot:run' 
* In the folder register-system-admin:
  * run 'npm init'
  * run 'npm start' to run the application in development mode
```

## Test it manually
The backend project has 2 endpoints useful for REST API testing.
http://localhost:8080/swagger-ui.html it is a page with the endpoints
 available and gives the possibility to test them directly from that page, without using tools like Postman or similar.
http://localhost:8080/v2/api-docs returns the json file to import in SWAGGER editor

at the address http://localhost:3000 it is possible to access the admin console.


## Author
**Gennaro Coppola** <coppola612@gmail.com>
