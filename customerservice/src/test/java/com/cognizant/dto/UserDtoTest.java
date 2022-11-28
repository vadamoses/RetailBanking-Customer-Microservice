/**
 * 
 */
package com.cognizant.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 2050610
 *
 */
class UserDtoTest {

	UserDto user;
	UserDto user2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		user = new UserDto();
		user2 = new UserDto(45, "user", "pass", "token101", "Employee");
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#getUserId()}.
	 */
	@Test
	void testGetUserId() {
		assertEquals(45, user2.getUserId());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#getUserName()}.
	 */
	@Test
	void testGetUserName() {
		assertEquals("user", user2.getUserName());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#getPassword()}.
	 */
	@Test
	void testGetPassword() {
		assertEquals("pass", user2.getPassword());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#getUserToken()}.
	 */
	@Test
	void testGetUserToken() {
		assertEquals("token101", user2.getUserToken());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#getUserRole()}.
	 */
	@Test
	void testGetUserRole() {
		assertEquals("Employee", user2.getUserRole());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#setUserId(long)}.
	 */
	@Test
	void testSetUserId() {
		user.setUserId(10);
		assertEquals(10, user.getUserId());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#setUserName(String)}.
	 */
	@Test
	void testSetUserName() {
		user.setUserName("User101");
		assertEquals("User101", user.getUserName());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#setPassword(String)}.
	 */
	@Test
	void testSetPassword() {
		user.setPassword("pass101");
		assertEquals("pass101", user.getPassword());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#setUserToken(String)}.
	 */
	@Test
	void testSetUserToken() {
		user.setUserToken("UserToken101");
		assertEquals("UserToken101", user.getUserToken());
	}

	/**
	 * Test method for {@link com.cognizant.dto.UserDto#setUserRole(String)}.
	 */
	@Test
	void testSetUserRole() {
		user.setUserRole("UserRole101");
		assertEquals("UserRole101", user.getUserRole());
	}

}
