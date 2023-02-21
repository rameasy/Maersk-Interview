package com.booking.maersk.app.model;

/**
 * The Enum ContainerType.
 */
public enum ContainerType {

	/** The dry. */
	DRY("DRY"),
	/** The reefer. */
	REEFER("REEFER");

	/**
	 * Instantiates a new container type.
	 *
	 * @param type the type
	 */
	ContainerType(String type) {
		this.type = type;
	}

	/** The type. */
	private String type;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
}
