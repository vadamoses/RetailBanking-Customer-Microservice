package com.cognizant.service;

import javax.validation.Valid;

import com.cognizant.model.AuthenticationResponse;
import com.cognizant.model.Customer;
import com.cognizant.model.CustomerCreationStatus;

public interface CustomerService {

	CustomerCreationStatus createCustomer(String token, @Valid Customer customer);

	Customer getCustomerDetails(String token, Long id);

	Customer getCustomer(Long id);

	Customer updateCustomer(@Valid Customer customer);

	boolean deleteCustomer(Long id);

	AuthenticationResponse hasPermission(String token);

	AuthenticationResponse hasEmployeePermission(String token);

	AuthenticationResponse hasCustomerPermission(String token);

}
