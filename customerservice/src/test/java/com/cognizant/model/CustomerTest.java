/**
 * 
 */
package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cognizant.dto.AccountDto;

/**
 * @author 2050610
 *
 */
class CustomerTest {

	Customer customer;
	AccountDto account;

	/**
	 * 
	 */
	@BeforeEach
	public void setUp() {
		account = new AccountDto(45, 6567, "Savings", 78.8f);

		customer = new Customer();
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#getCustomerid()}.
	 */
	@Test
	void testGetCustomerid() {
		customer.setCustomerid("CUSTOMER101");
		assertEquals("CUSTOMER101", customer.getCustomerid());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#getUsername()}.
	 */
	@Test
	void testGetUsername() {
		customer.setUsername("CUSTOMER101");
		assertEquals("CUSTOMER101", customer.getUsername());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		customer.setPassword("Password101");
		assertEquals("Password101", customer.getPassword());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#getAddress()}.
	 */
	@Test
	void testGetAddress() {
		customer.setAddress("Address101");
		assertEquals("Address101", customer.getAddress());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#getDateOfBirth()}.
	 */
	@Test
	void testGetDateOfBirth() {
		customer.setDateOfBirth(convertToDate("1989-08-03"));
		assertEquals(convertToDate("1989-08-03"), customer.getDateOfBirth());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#getPan()}.
	 */
	@Test
	void testGetPan() {
		customer.setPan("Pan101");
		assertEquals("Pan101", customer.getPan());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#getCustomerAccounts()}.
	 */
	@Test
	void testGetCustomerAccounts() {
		customer.setCustomerAccounts(Arrays.asList(account));
		assertEquals(Arrays.asList(account), customer.getCustomerAccounts());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#setCustomerid(String)}.
	 */
	@Test
	void testSetCustomerid() {
		customer.setCustomerid("CUSTOMER101");
		assertEquals("CUSTOMER101", customer.getCustomerid());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#setUsername(String)}.
	 */
	@Test
	void testSetUsername() {
		customer.setUsername("CUSTOMER101");
		assertEquals("CUSTOMER101", customer.getUsername());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#setPassword(String)}.
	 */
	@Test
	void testSetPassword() {
		customer.setPassword("Password101");
		assertEquals("Password101", customer.getPassword());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#setAddress(String)}.
	 */
	@Test
	void testSetAddress() {
		customer.setAddress("Address101");
		assertEquals("Address101", customer.getAddress());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#setDateOfBirth(Date)}.
	 */
	@Test
	void testSetDateOfBirth() {
		customer.setDateOfBirth(convertToDate("1989-08-03"));
		assertEquals(convertToDate("1989-08-03"), customer.getDateOfBirth());
	}

	/**
	 * Test method for {@link com.cognizant.model.Customer#setPan(String)}.
	 */
	@Test
	void testSetPan() {
		customer.setPan("Pan101");
		assertEquals("Pan101", customer.getPan());
	}

	/**
	 * Test method for
	 * {@link com.cognizant.model.Customer#setCustomerAccounts(List)}.
	 */
	@Test
	void testSetCustomerAccounts() {
		customer.setCustomerAccounts(Arrays.asList(account));
		assertEquals(Arrays.asList(account), customer.getCustomerAccounts());
	}

	public static Date convertToDate(String date) {
		SimpleDateFormat SDFormat = new SimpleDateFormat("yyyy-MM-dd");
		SDFormat.setLenient(false);
		Date tmpDate = new Date();
		try {
			tmpDate = SDFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tmpDate;
	}

}
