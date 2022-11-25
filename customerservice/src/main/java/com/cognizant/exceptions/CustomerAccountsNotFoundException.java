/**
 * 
 */
package com.cognizant.exceptions;

/**
 * @author 2050610
 *
 */
public class CustomerAccountsNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerAccountsNotFoundException(String message) {
		super(message);
	}
}
