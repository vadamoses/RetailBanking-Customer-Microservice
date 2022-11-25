/**
 * 
 */
package com.cognizant.exceptions;

/**
 * @author 2050610
 *
 */
public class CreateCustomerFailedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateCustomerFailedException(String message) {
		super(message);
	}
}
