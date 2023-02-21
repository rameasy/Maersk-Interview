package com.booking.maersk.app.exception;

/**
 * The Class ValidationException.
 */
public class ValidationException extends RuntimeException {
	
	/**
	 * Instantiates a new validation exception.
	 *
	 * @param errorMessage the error message
	 */
	public ValidationException(String errorMessage) {
		super(errorMessage);
	}
}
