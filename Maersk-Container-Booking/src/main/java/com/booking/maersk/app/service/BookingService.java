package com.booking.maersk.app.service;

import com.booking.maersk.app.request.ContainerBookingRequest;
import com.booking.maersk.app.response.AvailabilityResponse;
import com.booking.maersk.app.response.ContainerBookingResponse;

import reactor.core.publisher.Mono;

/**
 * The Interface BookingService.
 */
public interface BookingService {

	/**
	 * Check for containers.
	 *
	 * @param quantity the quantity
	 * @return the mono
	 */
	public Mono<AvailabilityResponse> checkForContainers(int quantity);

	/**
	 * Confirm.
	 *
	 * @param containerBookingRequest the container booking request
	 * @return the mono
	 */
	public Mono<ContainerBookingResponse> confirm(ContainerBookingRequest containerBookingRequest);
}
