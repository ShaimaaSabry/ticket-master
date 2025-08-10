package shaimaa.ticketmaster.infrastructure.repositories;

import org.springframework.stereotype.Component;
import shaimaa.ticketmaster.Booking;
import shaimaa.ticketmaster.BookingStatus;
import shaimaa.ticketmaster.contracts.BookingRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BookingRepositoryImpl implements BookingRepository {
    int WAITING_TIME_IN_MINUTES = 5;
    private final BookingSqlRepository bookingSqlRepository;

    private final TicketJpaRepository ticketJpaRepository;

    BookingRepositoryImpl(
            final BookingSqlRepository sqlBookingRepository,
            final TicketJpaRepository sqlShowTicketRepository) {
        this.bookingSqlRepository = sqlBookingRepository;
        this.ticketJpaRepository = sqlShowTicketRepository;
    }

    @Override
    public Set<Booking> findExpiredBookings(String showId) {
        Set<BookingEntity> bookingEntities =
                this.bookingSqlRepository.findAllByStatusAndCreatedOnLessThan(
                        BookingStatus.RESERVED,
                        LocalDateTime.now().minusMinutes(WAITING_TIME_IN_MINUTES));

        return bookingEntities.stream().map(b -> b.toBooking()).collect(Collectors.toSet());
    }

    @Override
    public Optional<Booking> findOneById(String bookingId) {
        return null;
    }

    @Override
//    @Transactional
    public Booking create(Booking booking) {
        BookingEntity bookingEntity = BookingEntity.from(booking);
        bookingEntity.setId(UUID.randomUUID().toString());
        try {
            bookingSqlRepository.save(bookingEntity);
        } catch(EntityNotFoundException e) {
            throw new IllegalArgumentException("Invalid showId.");
        }

        List<String> ticketIds = Arrays
                .stream(booking.getTickets())
                .map(t -> t.getId().toString()).
                collect(Collectors.toList());
        List<TicketEntity> ticketEntities = ticketJpaRepository.findAllById(ticketIds);
        for (TicketEntity ticketEntity: ticketEntities) {
            if (ticketEntity.getShow().getId() != bookingEntity.getShow().getId()) {
                throw new IllegalArgumentException("Ticket does not exist.");
            }

            if (ticketEntity.getBooking() != null) {
                throw new IllegalArgumentException("Ticket is not available.");
            }

            ticketEntity.setBooking(bookingEntity);
        }
        ticketJpaRepository.saveAll(ticketEntities);

        bookingEntity.setTickets(new HashSet<>(ticketEntities));
        return bookingEntity.toBooking();
    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    @Transactional
    public Booking expire(Booking booking) {
        Optional<BookingEntity> bookingEntity = bookingSqlRepository.findById(booking.getId());
        bookingEntity.get().setStatus(BookingStatus.EXPIRED);
        bookingSqlRepository.save(bookingEntity.get());

        List<String> ticketIds = Arrays
                .stream(booking.getTickets())
                .map(t -> t.getId().toString()).
                collect(Collectors.toList());
        List<TicketEntity> ticketEntities = ticketJpaRepository.findAllById(ticketIds);
        for (TicketEntity ticketEntity: ticketEntities) {
            ticketEntity.setBooking(null);
        }
        ticketJpaRepository.saveAll(ticketEntities);

        return bookingEntity.get().toBooking();
    }
}
