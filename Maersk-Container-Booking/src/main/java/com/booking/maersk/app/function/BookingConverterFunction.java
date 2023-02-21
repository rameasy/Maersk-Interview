package com.booking.maersk.app.function;

import java.time.Instant;
import java.util.function.Function;

import com.booking.maersk.app.model.Bookings;
import com.booking.maersk.app.request.ContainerBookingRequest;

/**
 * The Class BookingConverterFunction.
 */
public class BookingConverterFunction implements Function<ContainerBookingRequest, Bookings> {

	/** The booking reference id. */
	Integer bookingReferenceId;

	/**
	 * Instantiates a new booking converter function.
	 *
	 * @param bookingReferenceId the booking reference id
	 */
	public BookingConverterFunction(Integer bookingReferenceId) {
		this.bookingReferenceId = bookingReferenceId;
	}

	/**
	 * This method maps the containerBookingRequest object to the Bookings class
	 * object.
	 *
	 * @param containerBookingRequest the container booking request
	 * @return the bookings
	 */
	public Bookings map(ContainerBookingRequest containerBookingRequest) {
		return Bookings.builder().bookingRef(bookingReferenceId)
				.containerType(containerBookingRequest.getContainerType())
				.containerSize(containerBookingRequest.getContainerSize()).origin(containerBookingRequest.getOrigin())
				.destination(containerBookingRequest.getDestination()).quantity(containerBookingRequest.getQuantity())
				.creationTime(Instant.now()).build();
	}

	/**
	 * Apply.
	 *
	 * @param t the t
	 * @return the bookings
	 */
	@Override
	public Bookings apply(ContainerBookingRequest t) {
		return null;
	}
}
