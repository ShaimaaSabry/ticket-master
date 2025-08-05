package shaimaa.ticketmaster.api.v1.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shaimaa.ticketmaster.domain.Ticket;

public record TicketDTO (
    String id,
    float price
) {
    public static TicketDTO from(Ticket ticket) {
        return new TicketDTO(ticket.getId(), ticket.getPrice());
    }
}
