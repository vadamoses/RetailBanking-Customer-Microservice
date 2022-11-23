package com.cognizant.service;

import javax.validation.Valid;

import com.cognizant.model.Customer;

public interface CustomerService {

	Customer createCustomer(@Valid Customer customer);

	Customer getCustomerDetails(String id);

}
