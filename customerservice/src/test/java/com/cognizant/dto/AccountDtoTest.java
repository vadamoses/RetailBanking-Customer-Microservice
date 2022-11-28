/**
 * 
 */
package com.cognizant.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cognizant.model.Customer;

/**
 * @author 2050610
 *
 */
class AccountDtoTest {

	AccountDto account;
	AccountDto account2;
	Customer customer;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		account = new AccountDto();
		account2 = new AccountDto(45, 6567, "Savings", 78.8f);
		customer = new Customer();
	}

	/**
	 * Test method for {@link com.cognizant.dto.AccountDto#getAccountId()}.
	 */
	@Test
	void testGetAccountId() {
		account2.getAccountId();
		assertEquals(45, account2.getAccountId());
	}

	/**
	 * Test method for {@link com.cognizant.dto.AccountDto#getCustomerId()}.
	 */
	@Test
	void testGetCustomerId() {
		customer.setCustomerid("CUSTOMER101");
		assertEquals("CUSTOMER101", customer.getCustomerid());
	}

	/**
	 * Test method for {@link com.cognizant.dto.AccountDto#getAccountType()}.
	 */
	@Test
	void testGetAccountType() {
		account2.getAccountType();
		assertEquals("Savings", account2.getAccountType());
	}

	/**
	 * Test method for {@link com.cognizant.dto.AccountDto#getBalance()}.
	 */
	@Test
	void testGetBalance() {
		account2.getBalance();
		assertEquals(78.8f, account2.getBalance());
	}

	/**
	 * Test method for {@link com.cognizant.dto.AccountDto#setAccountId(long)}.
	 */
	@Test
	void testSetAccountId() {
		account.setAccountId(80);
		assertEquals(80, account.getAccountId());
	}

	/**
	 * Test method for {@link com.cognizant.dto.AccountDto#setCustomerId(long)}.
	 */
	@Test
	void testSetCustomerId() {
		customer.setCustomerid("CUSTOMER101");
		assertEquals("CUSTOMER101", customer.getCustomerid());
	}

	/**
	 * Test method for {@link com.cognizant.dto.AccountDto#setAccountType(String)}.
	 */
	@Test
	void testSetAccountType() {
		account.setAccountType("Current");
		assertEquals("Current", account.getAccountType());
	}

	/**
	 * Test method for {@link com.cognizant.dto.AccountDto#setBalance(float)}.
	 */
	@Test
	void testSetBalance() {
		account.setBalance(90.9f);
		assertEquals(90.9f, account.getBalance());
	}

}
