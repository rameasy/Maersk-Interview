package com.booking.maersk.app.function;

import java.util.function.Function;

import com.booking.maersk.app.response.AvailabilityResponse;
import com.booking.maersk.app.vo.AvailableSpaces;

/**
 * The Class RequestConverterFunction.
 */
public class RequestConverterFunction implements Function<AvailableSpaces, AvailabilityResponse> {

	/** The quantity. */
	Integer quantity;

	/**
	 * Instantiates a new request converter function.
	 *
	 * @param quantity the quantity
	 */
	public RequestConverterFunction(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * This method maps the available spaces object to the availability response
	 * based on the spaces available.
	 *
	 * @param spaces the spaces
	 * @return the availability response
	 */
	public AvailabilityResponse map(AvailableSpaces spaces) {
		return spaces.getAvailableSpace() > quantity ? AvailabilityResponse.builder().available(true).build()
				: AvailabilityResponse.builder().available(false).build();
	}

	/**
	 * Apply.
	 *
	 * @param t the t
	 * @return the availability response
	 */
	@Override
	public AvailabilityResponse apply(AvailableSpaces t) {
		return null;
	}
}
