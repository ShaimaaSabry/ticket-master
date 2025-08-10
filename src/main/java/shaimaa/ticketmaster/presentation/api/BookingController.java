package shaimaa.ticketmaster.presentation.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shaimaa.ticketmaster.BookingService;

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
        return null;
//        Booking booking = Booking.from(
//                "user1",
//                bookingRequestDTO.getShowId(),
//                Arrays.stream(bookingRequestDTO.getTickets()).map(t -> Ticket.from(t.id())).toArray(Ticket[]::new)
//        );
//
//        booking = bookingService.book(booking);
//
//        BookingResponseDTO bookingResponseDTO = bookingDtoMapper.map(booking);
////        BookingResponseDTO bookingResponseDTO = BookingResponseDTO.from(booking);
//        return new ResponseEntity<>(bookingResponseDTO, HttpStatus.CREATED);
    }
}
