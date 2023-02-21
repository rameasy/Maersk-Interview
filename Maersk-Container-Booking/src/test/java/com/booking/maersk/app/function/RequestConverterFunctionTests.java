package com.booking.maersk.app.function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.booking.maersk.app.response.AvailabilityResponse;
import com.booking.maersk.app.vo.AvailableSpaces;

/**
 * The Class RequestConverterFunctionTests.
 */
public class RequestConverterFunctionTests {

	/**
	 * Map when quantity is lesser than available space.
	 */
	@Test
	public void map_whenQuantityIsLesserThanAvailableSpace() {
		RequestConverterFunction rcf = new RequestConverterFunction(20);
		AvailableSpaces as = new AvailableSpaces();
		as.setAvailableSpace(25);
		AvailabilityResponse ar = rcf.map(as);
		assertTrue(ar.isAvailable());
	}

	/**
	 * Map when quantity is higher than available space.
	 */
	@Test
	public void map_whenQuantityIsHigherThanAvailableSpace() {
		RequestConverterFunction rcf = new RequestConverterFunction(20);
		AvailableSpaces as = new AvailableSpaces();
		as.setAvailableSpace(19);
		AvailabilityResponse ar = rcf.map(as);
		assertFalse(ar.isAvailable());
	}
}
