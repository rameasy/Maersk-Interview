package com.booking.maersk.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.booking.maersk.app.request.AvailabilityRequest;
import com.booking.maersk.app.request.ContainerBookingRequest;
import com.booking.maersk.app.response.AvailabilityResponse;
import com.booking.maersk.app.response.ContainerBookingResponse;

/**
 * The Class MaerskContainerBookingApplicationTests.
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class MaerskContainerBookingApplicationTests {

	/** The rest template. */
	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Check availability test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void checkAvailability_test() throws Exception {
		AvailabilityRequest ar = new AvailabilityRequest();
		ar.setContainerSize(20);
		ar.setQuantity(20);
		ar.setContainerType("DRY");
		ar.setOrigin("London");
		ar.setDestination("Berlin");

		ResponseEntity<AvailabilityResponse> res = this.restTemplate.postForEntity(
				"http://localhost:8080/api/bookings/container/checkAvailability", ar, AvailabilityResponse.class);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}

	/**
	 * Creates the booking test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void createBooking_test() throws Exception {
		ContainerBookingRequest cbr = new ContainerBookingRequest();
		cbr.setContainerSize(20);
		cbr.setQuantity(20);
		cbr.setContainerType("DRY");
		cbr.setOrigin("Baku");
		cbr.setDestination("Paris");
		cbr.setTimestamp(LocalDateTime.now());

		ResponseEntity<ContainerBookingResponse> res = this.restTemplate.postForEntity(
				"http://localhost:8080/api/bookings/container/book", cbr, ContainerBookingResponse.class);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
}
