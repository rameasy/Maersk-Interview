package com.booking.maersk.app.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.booking.maersk.app.model.ContainerType;
import com.booking.maersk.app.request.AvailabilityRequest;
import com.booking.maersk.app.request.ContainerBookingRequest;

import lombok.extern.slf4j.Slf4j;

/** The Constant log. */
@Slf4j
@Component
public class RequestValidator {

	/** The container type list. */
	private static List<String> containerTypeList = new ArrayList<>();
	static {
		containerTypeList.add(ContainerType.DRY.getType());
		containerTypeList.add(ContainerType.REEFER.getType());
	}

	/**
	 * This method validates the availability request object.
	 *
	 * @param availabilityRequest the availability request
	 * @return true, if successful
	 */
	public boolean validate(AvailabilityRequest availabilityRequest) {
		return validateContainerType(availabilityRequest.getContainerType())
				&& validateContainerSize(availabilityRequest.getContainerSize())
				&& validateQuantity(availabilityRequest.getQuantity())
				&& validateLocation(availabilityRequest.getOrigin())
				&& validateLocation(availabilityRequest.getDestination())
				&& !availabilityRequest.getOrigin().equals(availabilityRequest.getDestination());
	}

	/**
	 * This method validates the container booking request object.
	 *
	 * @param containerBookingRequest the container booking request
	 * @return true, if successful
	 */
	public boolean validate(ContainerBookingRequest containerBookingRequest) {
		return validateContainerType(containerBookingRequest.getContainerType())
				&& validateContainerSize(containerBookingRequest.getContainerSize())
				&& validateQuantity(containerBookingRequest.getQuantity())
				&& validateLocation(containerBookingRequest.getOrigin())
				&& validateLocation(containerBookingRequest.getDestination())
				&& !containerBookingRequest.getOrigin().equals(containerBookingRequest.getDestination());
	}

	/**
	 * Validate location.
	 *
	 * @param location the location
	 * @return true, if successful
	 */
	private boolean validateLocation(String location) {
		log.info("validateLocation method: {0}", location);
		return (location != null && !location.trim().isEmpty() && location.length() >= 5 && location.length() <= 20);
	}

	/**
	 * Validate container type.
	 *
	 * @param containerType the container type
	 * @return true, if successful
	 */
	private boolean validateContainerType(String containerType) {
		log.info("containerType method: {0}", containerType);
		return containerTypeList.contains(containerType);
	}

	/**
	 * Validate container size.
	 *
	 * @param containerSize the container size
	 * @return true, if successful
	 */
	private boolean validateContainerSize(Integer containerSize) {
		log.info("containerSize method: {0}", containerSize);
		return (containerSize != null && (containerSize == 20 || containerSize == 40));
	}

	/**
	 * Validate quantity.
	 *
	 * @param quantity the quantity
	 * @return true, if successful
	 */
	private boolean validateQuantity(Integer quantity) {
		log.info("validateQuantity method: {0}", quantity);
		return (quantity != null && quantity > 0 && quantity < 100);
	}

}
