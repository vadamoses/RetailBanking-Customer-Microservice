/**
 * 
 */
package com.cognizant.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.CustomerServiceApplication;
import com.cognizant.dto.AccountDto;
import com.cognizant.model.Customer;
import com.cognizant.repository.CustomerRepository;

/**
 * @author 2050610
 *
 */
@SpringBootTest
@ContextConfiguration(classes = { CustomerServiceApplication.class })
class CustomerServiceImplTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	CustomerService customerService;

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	Customer newCustomer;
	Customer returnedCustomer;
	AccountDto account;

	@BeforeEach
	public void setUp() {
		account = new AccountDto(45, 6567, "Savings", 78.8f);

		returnedCustomer = new Customer("CUSTOMER101", "mark", "mark101", "Amsterdam", convertToDate("1989-08-03"),
				"124", Arrays.asList(account));
	}

	/**
	 * Test method for
	 * {@link com.cognizant.service.CustomerServiceImpl#createCustomer(com.cognizant.model.Customer)}.
	 */
	@Test
	void testCreateCustomer() {
		// given
		given(customerService.createCustomer(newCustomer)).willReturn(returnedCustomer);

		// when
		Customer createdCustomer = customerService.createCustomer(newCustomer);

		// then
		assertThat(createdCustomer.getCustomerid(), is("CUSTOMER101"));
	}

	/**
	 * Test method for
	 * {@link com.cognizant.service.CustomerServiceImpl#getCustomerDetails(java.lang.String)}.
	 */
	@Test
	void testGetCustomerDetails() {
		// given
		given(customerService.getCustomerDetails(returnedCustomer.getCustomerid())).willReturn(returnedCustomer);

		// when
		Customer customerWithDetails = customerService.getCustomerDetails(returnedCustomer.getCustomerid());

		// then
		assertThat(customerWithDetails.getCustomerid(), is("CUSTOMER101"));
	}

	/**
	 * Test method for
	 * {@link com.cognizant.service.CustomerServiceImpl#updateCustomer(com.cognizant.model.Customer)}.
	 */
	@Test
	void testUpdateCustomer() {
		// given
		CustomerService customerSservice = spy(CustomerService.class);
		Customer updatedCustomer = returnedCustomer;
		updatedCustomer.setCustomerid("CUSTOMER105");
		
		// when
		doReturn(updatedCustomer).when(customerSservice).updateCustomer(returnedCustomer);

		// then
		assertThat(customerSservice.updateCustomer(returnedCustomer), is(updatedCustomer));

		verify(customerSservice).updateCustomer(updatedCustomer);
	}

	/**
	 * Test method for
	 * {@link com.cognizant.service.CustomerServiceImpl#deleteCustomer(java.lang.String)}.
	 */
	@Test
	void testDeleteCustomer() {
		// given
		CustomerService customerSservice = spy(CustomerService.class);
		// when
		doReturn(true).when(customerSservice).deleteCustomer(returnedCustomer.getCustomerid());

		// then
		assertTrue(customerSservice.deleteCustomer(returnedCustomer.getCustomerid()));

		verify(customerSservice).deleteCustomer(returnedCustomer.getCustomerid());
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
