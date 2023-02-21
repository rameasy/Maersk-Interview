package com.booking.maersk.app.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.booking.maersk.app.request.AvailabilityRequest;
import com.booking.maersk.app.request.ContainerBookingRequest;

/**
 * The Class RequestValidationTests.
 */
public class RequestValidationTests {

	/** The rv. */
	private RequestValidator rv = new RequestValidator();

	/**
	 * Validate when valid availability request is passed.
	 */
	@Test
	void validate_whenValidAvailabilityRequestIsPassed() {
		AvailabilityRequest ar = new AvailabilityRequest();
		ar.setContainerSize(20);
		ar.setQuantity(20);
		ar.setContainerType("DRY");
		ar.setOrigin("London");
		ar.setDestination("Berlin");
		assertTrue(rv.validate(ar));
	}

	/**
	 * Validate when valid container booking request is passed.
	 */
	@Test
	void validate_whenValidContainerBookingRequestIsPassed() {
		ContainerBookingRequest ar = new ContainerBookingRequest();
		ar.setContainerSize(20);
		ar.setQuantity(20);
		ar.setContainerType("DRY");
		ar.setOrigin("London");
		ar.setDestination("Berlin");
		ar.setTimestamp(LocalDateTime.now());
		assertTrue(rv.validate(ar));
	}

	/**
	 * Check availability when invalid container size is passed.
	 */
	@Test
	void checkAvailability_whenInvalidContainerSizeIsPassed() {
		ContainerBookingRequest ar = new ContainerBookingRequest();
		ar.setContainerSize(23);
		ar.setQuantity(20);
		ar.setContainerType("DRY");
		ar.setOrigin("London");
		ar.setDestination("Berlin");
		ar.setTimestamp(LocalDateTime.now());
		assertFalse(rv.validate(ar));
	}

	/**
	 * Check availability when invalid quantity is passed.
	 */
	@Test
	void checkAvailability_whenInvalidQuantityIsPassed() {
		AvailabilityRequest ar = new AvailabilityRequest();
		ar.setContainerSize(20);
		ar.setQuantity(120);
		ar.setContainerType("DRY");
		ar.setOrigin("London");
		ar.setDestination("Berlin");
		assertFalse(rv.validate(ar));
	}

	/**
	 * Check availability when invalid container type is passed.
	 */
	@Test
	void checkAvailability_whenInvalidContainerTypeIsPassed() {
		ContainerBookingRequest ar = new ContainerBookingRequest();
		ar.setContainerSize(20);
		ar.setQuantity(20);
		ar.setContainerType("DDD");
		ar.setOrigin("London");
		ar.setDestination("Berlin");
		ar.setTimestamp(LocalDateTime.now());
		assertFalse(rv.validate(ar));
	}

	/**
	 * Check availability when invalid origin is passed.
	 */
	@Test
	void checkAvailability_whenInvalidOriginIsPassed() {
		ContainerBookingRequest ar = new ContainerBookingRequest();
		ar.setContainerSize(20);
		ar.setQuantity(20);
		ar.setContainerType("DRY");
		ar.setOrigin("dsfgdsh jgjhgfghjghgghjghjghj g");
		ar.setDestination("Berlin");
		ar.setTimestamp(LocalDateTime.now());
		assertFalse(rv.validate(ar));
	}

	/**
	 * Check availability when invalid destination is passed.
	 */
	@Test
	void checkAvailability_whenInvalidDestinationIsPassed() {
		ContainerBookingRequest ar = new ContainerBookingRequest();
		ar.setContainerSize(40);
		ar.setQuantity(20);
		ar.setContainerType("DRY");
		ar.setOrigin("London");
		ar.setDestination("");
		ar.setTimestamp(LocalDateTime.now());
		assertFalse(rv.validate(ar));
	}

	/**
	 * Check availability when origin and destination are same.
	 */
	@Test
	void checkAvailability_whenOriginAndDestinationAreSame() {
		ContainerBookingRequest ar = new ContainerBookingRequest();
		ar.setContainerSize(40);
		ar.setQuantity(20);
		ar.setContainerType("DRY");
		ar.setOrigin("London");
		ar.setDestination("London");
		ar.setTimestamp(LocalDateTime.now());
		assertFalse(rv.validate(ar));
	}
}
