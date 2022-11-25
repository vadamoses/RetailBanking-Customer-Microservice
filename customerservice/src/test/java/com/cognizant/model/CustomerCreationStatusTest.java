/**
 * 
 */
package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 2050610
 *
 */
class CustomerCreationStatusTest {
	CustomerCreationStatus customer;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		customer = new CustomerCreationStatus();
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.CustomerCreationStatus#getMessage()}.
	 */
	@Test
	void testGetMessage() {
		customer.setMessage("msg");
		assertEquals("msg", customer.getMessage());
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.CustomerCreationStatus#getCustomerid()}.
	 */
	@Test
	void testGetCustomerid() {
		customer.setCustomerid("CUSTOMER101");
		assertEquals("CUSTOMER101", customer.getCustomerid());
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.CustomerCreationStatus#setMessage(String)}.
	 */
	@Test
	void testSetMessage() {
		customer.setMessage("msg");
		assertEquals("msg", customer.getMessage());
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.CustomerCreationStatus#setCustomerid(String)}.
	 */
	@Test
	void testSetCustomerid() {
		customer.setCustomerid("CUSTOMER101");
		assertEquals("CUSTOMER101", customer.getCustomerid());
	}

}
