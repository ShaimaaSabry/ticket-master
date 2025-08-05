package shaimaa.ticketmaster.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shaimaa.ticketmaster.api.v1.event.EventDTO;
import shaimaa.ticketmaster.api.v1.event.TicketDTO;
import shaimaa.ticketmaster.domain.Booking;
import shaimaa.ticketmaster.domain.BookingStatus;

import java.time.LocalDateTime;
import java.util.Arrays;

@AllArgsConstructor
@Getter
class BookingResponseDTO {
    private String id;
    private LocalDateTime createdOn;
    private EventDTO show;
    private TicketDTO[] tickets;
    private BookingStatus status;

    static BookingResponseDTO from(Booking booking) {
        return new BookingResponseDTO(
                booking.getId(),
                booking.getCreatedOn(),
                EventDTO.from(booking.getEvent()),
                Arrays.stream(booking.getTickets()).map(t -> TicketDTO.from(t)).toArray(TicketDTO[]::new),
                booking.getStatus());
    }
}
