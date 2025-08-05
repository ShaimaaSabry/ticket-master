package shaimaa.ticketmaster.api;

import lombok.Getter;
import shaimaa.ticketmaster.api.v1.event.TicketDTO;

@Getter
class BookingRequestDTO {
    private Long showId;
    private TicketDTO[] tickets;
}
