package com.cognizant.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.model.Customer;

import lombok.Data;

@Data
public class CustomerDto {

	private String customerid;

	private String username;

	private String password;

	private String address;

	private Date dateOfBirth;

	private String pan;

	private List<AccountDto> customerAccounts = new ArrayList<>();

	public Customer getCustomerFromDto() {
		Customer customer = new Customer();
		customer.setCustomerid(customerid);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setDateOfBirth(dateOfBirth);
		customer.setPan(pan);
		customer.setCustomerAccounts(customerAccounts);

		return customer;
	}
}
