package shaimaa.ticketmaster.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaimaa.ticketmaster.domain.Booking;
import shaimaa.ticketmaster.domain.BookingService;
import shaimaa.ticketmaster.domain.Ticket;
import shaimaa.ticketmaster.domain.TicketNotAvailableException;

import java.util.Arrays;

@RestController
@RequestMapping("v1/bookings")
class BookingController {
    private BookingService bookingService;
    private BookingDtoMapper bookingDtoMapper;

    BookingController(BookingService bookingService, BookingDtoMapper bookingDtoMapper) {
        this.bookingService = bookingService;
        this.bookingDtoMapper = bookingDtoMapper;
    }

    @PostMapping
    ResponseEntity<BookingResponseDTO> createOne(@RequestBody BookingRequestDTO bookingRequestDTO) {
        Booking booking = Booking.from(
                "user1",
                bookingRequestDTO.getShowId(),
                Arrays.stream(bookingRequestDTO.getTickets()).map(t -> Ticket.from(t.id())).toArray(Ticket[]::new)
        );

        booking = bookingService.book(booking);

        BookingResponseDTO bookingResponseDTO = bookingDtoMapper.map(booking);
//        BookingResponseDTO bookingResponseDTO = BookingResponseDTO.from(booking);
        return new ResponseEntity<>(bookingResponseDTO, HttpStatus.CREATED);
    }
}
