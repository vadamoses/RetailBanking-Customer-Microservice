package com.cognizant.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Customer;
import com.cognizant.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(@Valid Customer customer) {
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
		log.info("Customer Details Retrieved.");
		return customerOptional.get();
	}

}
