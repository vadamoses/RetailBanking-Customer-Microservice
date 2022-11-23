package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
