package com.booking.maersk.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.maersk.app.exception.ValidationException;
import com.booking.maersk.app.request.AvailabilityRequest;
import com.booking.maersk.app.request.ContainerBookingRequest;
import com.booking.maersk.app.response.AvailabilityResponse;
import com.booking.maersk.app.response.ContainerBookingResponse;
import com.booking.maersk.app.service.BookingService;
import com.booking.maersk.app.validator.RequestValidator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/container")
public class BookingController {

	/** The booking service. */
	@Autowired
	private final BookingService bookingService;

	/** The validator. */
	@Autowired
	private final RequestValidator validator;

	/**
	 * 
	 * This method helps to check the availability of the containers available in the system. 
	 *
	 * @param request the request
	 * @return the response entity
	 */
	@PostMapping("/checkAvailability")
	public ResponseEntity<Mono<AvailabilityResponse>> checkAvailability(
			@RequestBody final AvailabilityRequest request) {
		log.info("Entering checkAvailability method: {0}" , request);
		if (!validator.validate(request)) {
			log.info("Validation failed");
			throw new ValidationException("Invalid Availability Request");
		}
		Mono<AvailabilityResponse> response = bookingService.checkForContainers(request.getQuantity());
		log.info("Exiting checkAvailability method: {0}" , response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * This method helps to create the container booking.
	 *
	 * @param containerBookingRequest the container booking request
	 * @return the mono
	 */
	@PostMapping("/book")
	public Mono<ResponseEntity<ContainerBookingResponse>> createBooking(
			@RequestBody ContainerBookingRequest containerBookingRequest) {
		log.info("Entering createBooking method: {0}" , containerBookingRequest);
		if (!validator.validate(containerBookingRequest)) {
			log.info("Validation failed");
			throw new ValidationException("Invalid Booking Request");
		}
		return bookingService.confirm(containerBookingRequest).map(confirmed -> ResponseEntity.ok().body(confirmed))
				.onErrorReturn(ResponseEntity.badRequest().build());
	}

}
