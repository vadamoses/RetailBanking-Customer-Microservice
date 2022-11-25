/**
 * 
 */
package com.cognizant.exceptions;

/**
 * @author 2050610
 *
 */
public class UserNotAuthorizedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotAuthorizedException(String message) {
		super(message);
	}
}
