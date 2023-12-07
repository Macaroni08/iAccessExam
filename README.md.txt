# iAccessExam

Simple exam to showcase Spring Web knowledge using CRUD operations. This is used to store whitelisted IPv4 addresses for different environments and applications.

## Description

This is a system that stores whitelisted IPv4 addresses from Users by different environments and applications. The system can only accept IPv4 addresses. It can filter unique whitelisted addresses, by environment, by application, and by client name.

## Getting Started

### Dependencies

* Postman or any API Platform
* MySQL or any database management system
* Eclipse or any IDE for Java

### Installing

* Download the file and run it on any IDE for Java
* Change the JDBC connections found on application.properties

### Executing program

* Open your database management system
* Create your own database if you haven't created yet
* Copy the JDBC Connection String
* Open iAccessExam file on Java IDE
* Change and paste your JDBC Connection String on spring.datasource.url, which can be found on application.properties on src/main/resources
* Change the username and password on application.properties
* Run the program as a Spring Boot Application
* Open the Postman or any API Platform
* Input your localhost port. The default is localhost:8080
* The URL for Listing, Adding, and Deleting data is localhost:8080/whitelist
* For getting the data, set the API platform to GET and run localhost:8080/whitelist
* For adding data, set the API platform to POST and run localhost:8080/whitelist
* You can use JSON format for adding data. 
* ID is auto increment
* You must input a client name
* You must input a valid IPv4 address
* You must input a valid environment
* You must input a valid application
* For deleting data, set the API platform to DELETE and input the id number you want to delete. Then run localhost:8080/whitelist
* For filtering all by environment, set the API platform to GET and run localhost:8080/whitelist/environment/{environment}
* For filtering all by application, set the API platform to GET and run localhost:8080/whitelist/application/{application}
* For filtering all by client name, set the API platform to GET and run localhost:8080/whitelist/clientName/{clientName}
* For filtering unique whitelisted, set the API platform to GET and run localhost:8080/whitelist/unique
* For filtering unique whitelisted by environment, set the API platform to GET and run localhost:8080/whitelist/unique/environment/{environment}
* For filtering unique whitelisted by application, set the API platform to GET and run localhost:8080/whitelist/unique/application/{application}
* For filtering unique whitelisted by client name, set the API platform to GET and run localhost:8080/whitelist/unique/clientName/{clientName}

```
code blocks for commands
```

## Help

Change parameters if error.
```

```

## Authors

Contributors names and contact info

John Ferry Esteban
https://www.linkedin.com/in/john-ferry-esteban-3aa172229/

## Version History

* 0.1
    * Initial Release

## License

This project is licensed under the [] License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* AmigosCode
* Youtube
* Stackoverflow
* Reddit
* Baeldung