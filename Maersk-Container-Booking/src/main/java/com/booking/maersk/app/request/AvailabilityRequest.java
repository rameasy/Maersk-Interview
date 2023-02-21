package com.booking.maersk.app.request;

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
public class AvailabilityRequest {

	/** The container type. */
	private String containerType;

	/** The container size. */
	private Integer containerSize;

	/** The origin. */
	private String origin;

	/** The destination. */
	private String destination;

	/** The quantity. */
	private Integer quantity;
}
