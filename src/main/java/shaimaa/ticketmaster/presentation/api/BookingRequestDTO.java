package shaimaa.ticketmaster.presentation.api;

import lombok.Getter;
import shaimaa.ticketmaster.presentation.api.v1.event.TicketDTO;

@Getter
class BookingRequestDTO {
    private Long showId;
    private TicketDTO[] tickets;
}
