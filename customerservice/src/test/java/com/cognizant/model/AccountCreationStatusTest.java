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
class AccountCreationStatusTest {
	AccountCreationStatus account;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		account = new AccountCreationStatus();
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.AccountCreationStatus#getMessage()}.
	 */
	@Test
	void testGetMessage() {
		account.setMessage("msg");
		assertEquals("msg", account.getMessage());
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.AccountCreationStatus#getAccountid()}.
	 */
	@Test
	void testGetAccountid() {
		account.setAccountid("CUSTOMER101");
		assertEquals("CUSTOMER101", account.getAccountid());
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.AccountCreationStatus#setMessage(String)}.
	 */
	@Test
	void testSetMessage() {
		account.setMessage("msg");
		assertEquals("msg", account.getMessage());
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.AccountCreationStatus#setAccountid(String)}.
	 */
	@Test
	void testSetAccountid() {
		account.setAccountid("CUSTOMER101");
		assertEquals("CUSTOMER101", account.getAccountid());
	}

}
