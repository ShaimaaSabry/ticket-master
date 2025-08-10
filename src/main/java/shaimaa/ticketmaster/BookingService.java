package shaimaa.ticketmaster;

import org.springframework.stereotype.Service;
import shaimaa.ticketmaster.contracts.BookingRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserWaitingService userWaitingService;

    public BookingService(
            final BookingRepository bookingRepository,
            final UserWaitingService userWaitingService) {
        this.bookingRepository = bookingRepository;
        this.userWaitingService = userWaitingService;
    }

    public Booking book(Booking booking) {
        return bookingRepository.create(booking);
    }

    public Booking purchase(Booking booking) {
        booking.purchase();
        booking = bookingRepository.update(booking);
        return booking;
    }

    public void sendBookingConfirmationEmail(final String bookingId) {
        Optional<Booking> booking = this.bookingRepository.findOneById(bookingId);
        if (booking.isEmpty()) {
            throw new IllegalArgumentException("Invalid bookingId");
        }
    }

    public void expireBookings(String showId) {
        Set<Booking> bookingsToCancel = bookingRepository.findExpiredBookings(showId);
        for(Booking booking: bookingsToCancel) {
            this.expireBooking(booking);
        }
    }

    public void expireBooking(Booking booking) {
        bookingRepository.expire(booking);
        userWaitingService.notifyUsers(booking.getEvent().getId());
    }
}
