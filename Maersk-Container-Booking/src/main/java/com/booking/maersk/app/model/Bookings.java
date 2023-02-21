package com.booking.maersk.app.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * The Class Bookings.
 */
@Table
@AllArgsConstructor
@Getter
@Builder
public class Bookings {

	/** The booking ref. */
	@Id
	@PrimaryKeyColumn
	@Column("booking_ref")
	@CassandraType(type = CassandraType.Name.INT)
	private Integer bookingRef;

	/** The container type. */
	@Column("container_type")
	@CassandraType(type = CassandraType.Name.TEXT)
	private String containerType;

	/** The container size. */
	@Column("container_size")
	@CassandraType(type = CassandraType.Name.INT)
	private Integer containerSize;

	/** The origin. */
	@CassandraType(type = CassandraType.Name.TEXT)
	private String origin;

	/** The destination. */
	@CassandraType(type = CassandraType.Name.TEXT)
	private String destination;

	/** The quantity. */
	@CassandraType(type = CassandraType.Name.INT)
	private Integer quantity;

	/** The creation time. */
	@Column("creation_time")
	@CassandraType(type = CassandraType.Name.TIMESTAMP)
	private Instant creationTime;
}
