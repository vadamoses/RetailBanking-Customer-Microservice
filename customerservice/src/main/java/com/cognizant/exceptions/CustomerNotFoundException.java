/**
 * 
 */
package com.cognizant.exceptions;

/**
 * @author 2050610
 *
 */
public class CustomerNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(String message) {
		super(message);
	}
}
