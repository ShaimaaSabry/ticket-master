package shaimaa.ticketmaster.presentation.api.v1.event;

import shaimaa.ticketmaster.model.Ticket;

public record TicketDTO (
    long id,
    float price
) {
    public static TicketDTO from(Ticket ticket) {
        return new TicketDTO(ticket.getId(), 0);
    }
}
