package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dto.AccountDto;
import com.cognizant.exceptions.AccessDeniedException;
import com.cognizant.feign.AccountServiceClient;
import com.cognizant.feign.AuthenticationServiceClient;
import com.cognizant.model.AuthenticationResponse;
import com.cognizant.model.Customer;
import com.cognizant.model.CustomerCreationStatus;
import com.cognizant.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountServiceClient accountServiceClient;

	@Autowired
	AuthenticationServiceClient authenticationServiceClient;

	@Override
	public CustomerCreationStatus createCustomer(String token, @Valid Customer customer) {
		/*
		 * check if customer already exists,then interact with the Account Service to
		 * create the customer’s account
		 */
		Customer existingCustomerDetails = getCustomerDetails(token, customer.getCustomerid());

		if (existingCustomerDetails == null) {
			/* create new user of type customer with the authentication service */
		}

		for (AccountDto account : customer.getCustomerAccounts()) {
			accountServiceClient.createAccount(token, customer.getCustomerid(), account);
		}

		customerRepository.save(customer);
		CustomerCreationStatus customerCreationStatus = new CustomerCreationStatus(customer.getCustomerid(),
				"Sucessfully Created");
		log.info("New Customer Added.");
		return customerCreationStatus;
	}

	@Override
	public Customer getCustomer(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);

		if (!customerOptional.isPresent()) {
			return null;
		}
		return customerOptional.get();
	}

	@Override
	public Customer getCustomerDetails(String token, Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);

		/* Check if optional is returning empty value before invoking .get() */
		if (!customerOptional.isPresent()) {
			return null;
		}
		/* get list of accounts from accounts service */

		List<AccountDto> customerAccounts = accountServiceClient.getCustomerAccount(token, id);
		Customer customerWithDetails = customerOptional.get();

		/* add returned list of accounts to customer */
		customerWithDetails.setCustomerAccounts(customerAccounts);

		log.info("Customer Details Retrieved.");
		return customerWithDetails;
	}

	@Override
	public Customer updateCustomer(@Valid Customer customer) {
		Optional<Customer> customerToUpdate = customerRepository.findById(customer.getCustomerid());
		if (!customerToUpdate.isPresent()) {
			return null;
		}

		Customer updatedCustomer = customerToUpdate.get();

		/* add given list of accounts to the updated customer customer */
		updatedCustomer.setCustomerAccounts(customer.getCustomerAccounts());

		return customerRepository.save(updatedCustomer);
	}

	@Override
	public boolean deleteCustomer(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (!customerOptional.isPresent()) {
			return false;
		}
		/* delete customer if found */
		customerRepository.deleteById(id);
		log.info("Customer deleted.");
		return true;
	}

	@Override
	public AuthenticationResponse hasPermission(String token) {
		return authenticationServiceClient.tokenValidation(token);
	}

	@Override
	public AuthenticationResponse hasEmployeePermission(String token) {
		AuthenticationResponse tokenValidity = authenticationServiceClient.tokenValidation(token);
		if (!authenticationServiceClient.getRole(tokenValidity.getUserid()).equalsIgnoreCase("EMPLOYEE")) {
			throw new AccessDeniedException("NOT ALLOWED");
		}
		return tokenValidity;
	}

	@Override
	public AuthenticationResponse hasCustomerPermission(String token) {
		AuthenticationResponse tokenValidity = authenticationServiceClient.tokenValidation(token);
		if (!authenticationServiceClient.getRole(tokenValidity.getUserid()).equalsIgnoreCase("CUSTOMER")) {
			throw new AccessDeniedException("NOT ALLOWED");
		}
		return tokenValidity;
	}

}
