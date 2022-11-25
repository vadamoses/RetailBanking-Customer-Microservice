/**
 * 
 */
package com.cognizant.exceptions;

/**
 * @author 2050610
 *
 */
public class LoginUserFailedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginUserFailedException(String message) {
		super(message);
	}
}
