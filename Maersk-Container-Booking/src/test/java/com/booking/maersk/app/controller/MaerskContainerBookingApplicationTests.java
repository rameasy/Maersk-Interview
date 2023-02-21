package com.booking.maersk.app;

import static org.junit.Assert.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.booking.maersk.app.request.AvailabilityRequest;
import com.booking.maersk.app.request.ContainerBookingRequest;
import com.booking.maersk.app.response.AvailabilityResponse;
import com.booking.maersk.app.response.ContainerBookingResponse;
import com.datastax.oss.driver.api.core.servererrors.AlreadyExistsException;

/**
 * The Class MaerskContainerBookingApplicationTests.
 */
@SpringBootTest
//@RunWith(JUnit4.class)
class MaerskContainerBookingApplicationTests {

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

		assertThrows(AlreadyExistsException.class, () -> {
			TestRestTemplate restTemplate = new TestRestTemplate();
			ResponseEntity<AvailabilityResponse> res = restTemplate.postForEntity(
					"http://localhost:8080/api/bookings/container/checkAvailability", ar, AvailabilityResponse.class);

		});
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

		assertThrows(AlreadyExistsException.class, () -> {
			TestRestTemplate restTemplate = new TestRestTemplate();
			ResponseEntity<ContainerBookingResponse> res = restTemplate.postForEntity(
					"http://localhost:8080/api/bookings/container/book", cbr, ContainerBookingResponse.class);

		});
	}
}
