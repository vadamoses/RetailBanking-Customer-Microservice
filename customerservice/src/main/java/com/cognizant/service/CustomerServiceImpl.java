package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dto.AccountDto;
import com.cognizant.feign.AccountServiceClient;
import com.cognizant.model.Customer;
import com.cognizant.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	/*
	 * @Autowired AccountServiceClient accountServiceClient;
	 */

	@Override
	public Customer createCustomer(@Valid Customer customer) {
		/*
		 * check if customer already exists,then interact with the Account Service to
		 * create the customer’s account
		 */
		Customer existingCustomerDetails = getCustomerDetails(customer.getCustomerid());

		if (existingCustomerDetails == null) {
			/* create new user of type customer with the authentication service */
		}

		for (AccountDto account : customer.getCustomerAccounts()) {
			//accountServiceClient.createAccount(account, customer.getCustomerid());
		}

		customerRepository.save(customer);
		log.info("New Customer Added.");
		return customer;
	}

	@Override
	public Customer getCustomerDetails(String id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);

		/* Check if optional is returning empty value before invoking .get() */
		if (!customerOptional.isPresent()) {
			return null;
		}
		/* get list of accounts from accounts service */
		//List<AccountDto> customerAccounts = accountServiceClient.getCustomerAccounts(id);
		//Customer customerWithDetails = customerOptional.get();

		/* add returned list of accounts to customer */
		//customerWithDetails.setCustomerAccounts(customerAccounts);

		log.info("Customer Details Retrieved.");
		return customerOptional.get();
		//return customerWithDetails;
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
	public boolean deleteCustomer(String id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (!customerOptional.isPresent()) {
			return false;
		}
		/* delete customer if found */
		customerRepository.deleteById(id);
		log.info("Customer deleted.");
		return true;
	}

}
