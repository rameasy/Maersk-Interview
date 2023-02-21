package com.booking.maersk.app.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ContainerBookingResponse {

	/** The booking ref. */
	private String bookingRef;
}
