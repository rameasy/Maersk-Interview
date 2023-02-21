package com.booking.maersk.app.function;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.booking.maersk.app.function.BookingConverterFunction;
import com.booking.maersk.app.model.Bookings;
import com.booking.maersk.app.request.ContainerBookingRequest;

/**
 * The Class BookingConverterFunctionTests.
 */
public class BookingConverterFunctionTests {

	/**
	 * Map when container booking request is passed.
	 */
	@Test
	public void map_whenContainerBookingRequestIsPassed() {
		BookingConverterFunction bcf = new BookingConverterFunction(957000001);
		ContainerBookingRequest ar = new ContainerBookingRequest();
		ar.setContainerSize(20);
		ar.setQuantity(20);
		ar.setContainerType("DRY");
		ar.setOrigin("London");
		ar.setDestination("Berlin");
		ar.setTimestamp(LocalDateTime.now());
		Bookings booking = bcf.map(ar);
		assertEquals(957000001, booking.getBookingRef());
	}
}
