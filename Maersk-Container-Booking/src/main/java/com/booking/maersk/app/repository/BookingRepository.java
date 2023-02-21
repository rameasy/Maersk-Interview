package com.booking.maersk.app.repository;

import java.math.BigInteger;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.booking.maersk.app.model.Bookings;

/**
 * The Interface BookingRepository.
 */
@Repository
public interface BookingRepository extends ReactiveCassandraRepository<Bookings, BigInteger> {

	/**
	 * Find max id.
	 *
	 * @return the integer
	 */
	@Query(value = "select max(booking_ref) from Bookings")
	Integer findMaxId();
}
