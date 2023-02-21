package com.booking.maersk.app.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class ContainerBookingRequest {

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

	/** The timestamp. */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;
}
