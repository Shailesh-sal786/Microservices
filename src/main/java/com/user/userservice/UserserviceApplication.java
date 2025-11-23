package com.user.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

//Changes in Eureka Client Setup
//
//Spring Boot's auto-configuration automatically enables Eureka Client functionality as soon as you include the spring-cloud-starter-netflix-eureka-client dependency in your project.
//
//You no longer need to annotate your main application class with @EnableEurekaClient. Simply adding the dependency and configuring Eureka in the application.properties or application.yml is sufficient for your application to register with the Eureka server.

@SpringBootApplication
public class UserserviceApplication {



	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);


	}

}
