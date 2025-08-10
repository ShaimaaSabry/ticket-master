package shaimaa.ticketmaster.application.queries.GetEventAvailableTickets;

import org.springframework.stereotype.Component;
import shaimaa.ticketmaster.model.Ticket;
import shaimaa.ticketmaster.contracts.EventRepository;

import java.util.Set;

@Component
public class GetEventAvailableTicketsHandler {
    private static final int RESERVED_WAIT_TIME_IN_MINUTES = 15;

    private final EventRepository eventRepository;

    public GetEventAvailableTicketsHandler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Set<Ticket> handle(Long eventId) {
        return this.eventRepository.getAvailableTickets(eventId, RESERVED_WAIT_TIME_IN_MINUTES);
    }
}
