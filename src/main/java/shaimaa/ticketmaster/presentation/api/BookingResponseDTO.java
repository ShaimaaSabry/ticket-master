package shaimaa.ticketmaster.presentation.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shaimaa.ticketmaster.presentation.api.v1.event.EventItemDTO;
import shaimaa.ticketmaster.presentation.api.v1.event.TicketDTO;
import shaimaa.ticketmaster.Booking;
import shaimaa.ticketmaster.BookingStatus;

import java.time.LocalDateTime;
import java.util.Arrays;

@AllArgsConstructor
@Getter
class BookingResponseDTO {
    private String id;
    private LocalDateTime createdOn;
    private EventItemDTO show;
    private TicketDTO[] tickets;
    private BookingStatus status;

    static BookingResponseDTO from(Booking booking) {
        return new BookingResponseDTO(
                booking.getId(),
                booking.getCreatedOn(),
                EventItemDTO.from(booking.getEvent()),
                Arrays.stream(booking.getTickets()).map(t -> TicketDTO.from(t)).toArray(TicketDTO[]::new),
                booking.getStatus());
    }
}
