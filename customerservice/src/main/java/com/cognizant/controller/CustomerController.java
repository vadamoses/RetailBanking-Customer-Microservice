package com.cognizant.controller;

import java.net.BindException;
import java.time.DateTimeException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dto.CustomerDto;
import com.cognizant.model.Customer;
import com.cognizant.model.CustomerCreationStatus;
import com.cognizant.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customer")
@CrossOrigin
@EnableEurekaClient
@Tag(name = "Customer service endpoints")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Operation(summary = "Used to create a new customer and associated customer account.")
	@PostMapping("/createCustomer")
	public CustomerCreationStatus createCustomer(
			@Parameter(description = "Customer object to be saved") @Valid @RequestBody CustomerDto customer,
			BindingResult bindingResult) throws DateTimeException, BindException {
		log.info("Inside the createCustomer EndPoint : Begin");

		if (bindingResult.hasErrors()) {
			throw new BindException();
		}
		Customer newCustomer = customer.getCustomerFromDto();
		customerService.createCustomer(newCustomer);

		log.info("Inside the createCustomer EndPoint : End");
		return new CustomerCreationStatus("Customer Creation SUCCESSFUL", newCustomer.getCustomerid());
	}

	@Operation(summary = "Used to retrieve customer details including a list of customer accounts.")
	@GetMapping("/getCustomerDetails/{customerId}")
	public Customer getCustomerDetails(
			@Parameter(description = "id of customer to be searched") @PathVariable("customerId") String customerId) {
		log.info("Inside the getCustomerDetails EndPoint : Begin");
		Customer customerWithDetails = customerService.getCustomerDetails(customerId);
		log.info("Inside the getCustomerDetails EndPoint : End");
		return customerWithDetails;
	}

}
