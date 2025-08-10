package shaimaa.ticketmaster.contracts;

import shaimaa.ticketmaster.Booking;

import java.util.Optional;
import java.util.Set;

public interface BookingRepository {
    Set<Booking> findExpiredBookings(String showId);
    Optional<Booking> findOneById(String bookId);
    Booking create(Booking booking);
    Booking update(Booking booking);
    Booking expire(Booking booking);
}
