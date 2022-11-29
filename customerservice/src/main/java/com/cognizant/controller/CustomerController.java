package com.cognizant.controller;

import java.net.BindException;
import java.time.DateTimeException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dto.CustomerDto;
import com.cognizant.exceptions.CreateCustomerFailedException;
import com.cognizant.exceptions.CustomerNotFoundException;
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
	/*
	 * When using @PathVariable for Feign Client, always
	 * use @PathVariable(value="xxx") property or it will give you the error
	 * java.lang.IllegalStateException: PathVariable annotation was empty on param 0
	 */

	@Autowired
	private CustomerService customerService;

	@Operation(summary = "Used to create a new customer and associated customer account.")
	@PostMapping("/createCustomer")
	public CustomerCreationStatus createCustomer(@RequestHeader("Authorization") String token,
			@Parameter(description = "Customer object to be saved") @Valid @RequestBody CustomerDto customer,
			BindingResult bindingResult) throws DateTimeException, BindException, CreateCustomerFailedException {
		log.info("Inside the createCustomer EndPoint : Begin");

		if (bindingResult.hasErrors()) {
			throw new BindException();
		}
		customerService.hasPermission(token);

		Customer newCustomer = customer.getCustomerFromDto();
		CustomerCreationStatus createdCustomer = customerService.createCustomer(token, newCustomer);

		if (createdCustomer == null) {
			throw new CreateCustomerFailedException("Customer Creation is UNSUCCESSFUL");
		}

		log.info("Inside the createCustomer EndPoint : End");
		return createdCustomer;
	}

	@Operation(summary = "Used to retrieve customer details including a list of customer accounts.")
	@GetMapping("/getCustomerDetails/{customerId}")
	public Customer getCustomerDetails(@RequestHeader("Authorization") String token,
			@Parameter(description = "id of customer to be searched") @PathVariable(value = "customerId") Long customerId)
			throws CustomerNotFoundException {
		log.info("Inside the getCustomerDetails EndPoint : Begin");
		customerService.hasPermission(token);

		Customer customerWithDetails = customerService.getCustomerDetails(token, customerId);
		if (customerWithDetails == null) {
			throw new CustomerNotFoundException("Customer Details Not Found");
		}
		log.info("Inside the getCustomerDetails EndPoint : End");
		return customerWithDetails;
	}

	@PostMapping("/updateCustomer")
	public Customer updateCustomer(@RequestHeader("Authorization") String token,
			@Valid @RequestBody CustomerDto customer) {
		log.info("Inside the updateCustomer EndPoint : Start");
		customerService.hasEmployeePermission(token);
		Customer newCustomer = customer.getCustomerFromDto();
		log.info("Inside the updateCustomer EndPoint : End");
		return customerService.updateCustomer(newCustomer);
	}

	@DeleteMapping("deleteCustomer/{customerId}")
	public Boolean deleteCustomer(@RequestHeader("Authorization") String token,
			@PathVariable(value = "customerId") Long customerId) {
		log.info("Inside the deleteCustomer EndPoint : Start");
		customerService.hasEmployeePermission(token);
		log.info("Inside the deleteCustomer EndPoint : End");
		return customerService.deleteCustomer(customerId);
	}

}
