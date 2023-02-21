package com.booking.maersk.app.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.booking.maersk.app.function.BookingConverterFunction;
import com.booking.maersk.app.function.RequestConverterFunction;
import com.booking.maersk.app.repository.BookingRepository;
import com.booking.maersk.app.request.ContainerBookingRequest;
import com.booking.maersk.app.response.AvailabilityResponse;
import com.booking.maersk.app.response.ContainerBookingResponse;
import com.booking.maersk.app.service.BookingService;
import com.booking.maersk.app.vo.AvailableSpaces;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/** The Constant log. */
@Slf4j
@Service
public class BookingServiceImpl implements BookingService {

	/** The web client. */
	private final WebClient webClient;

	/** The booking repository. */
	private final BookingRepository bookingRepository;

	/**
	 * Instantiates a new booking service impl.
	 *
	 * @param webClientBuilder  the web client builder
	 * @param bookingRepository the booking repository
	 */
	public BookingServiceImpl(WebClient.Builder webClientBuilder, BookingRepository bookingRepository) {
		log.info("Initializing the BookingService constructor");
		this.webClient = webClientBuilder.baseUrl("http://localhost:8080/api/bookings").build();
		this.bookingRepository = bookingRepository;
	}

	/**
	 * This method checks for containers by hitting the another URI.
	 *
	 * @param quantity the quantity
	 * @return the mono
	 */
	@Override
	public Mono<AvailabilityResponse> checkForContainers(int quantity) {
		log.info("Entering checkForContainers with the quantity {0}", quantity);
		RequestConverterFunction converter = new RequestConverterFunction(quantity);
		return webClient.get().uri("/container/checkAvailable").retrieve().bodyToMono(AvailableSpaces.class)
				.map(converter);
	}

	/**
	 * This method creates new booking reference id and save the booking and returns
	 * same reference id.
	 *
	 * @param containerBookingRequest the container booking request
	 * @return the mono
	 */
	@Override
	public Mono<ContainerBookingResponse> confirm(ContainerBookingRequest containerBookingRequest) {
		Integer bookingReferenceId = bookingRepository.findMaxId();
		log.info("bookingReferenceId value :  {0}", bookingReferenceId);
		if (bookingReferenceId == null || bookingReferenceId <= 957000000) { // this is for first time execution
			bookingReferenceId = 957000000;
		}
		bookingReferenceId += 1; // incrementing the id
		BookingConverterFunction converter = new BookingConverterFunction(bookingReferenceId);
		log.info("Saving the booking details");
		return webClient.post().uri("/container/saveBooking").bodyValue(converter).retrieve()
				.bodyToMono(ContainerBookingResponse.class);
	}

}
