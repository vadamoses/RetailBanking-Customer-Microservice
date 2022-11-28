package com.cognizant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceApplicationTests {

	/**
	 * 
	 */
	@Test
	void contextLoads() {
		String check = "Customer101";
		assertEquals("Customer101", check);
	}

}
