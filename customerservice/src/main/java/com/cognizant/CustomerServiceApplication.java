package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


/* Cannot use Feign yet :( */

//@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer Service", version = "1.0", description = "This service is used to create a new customer, as well as retrieve a customer's account details."))
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
