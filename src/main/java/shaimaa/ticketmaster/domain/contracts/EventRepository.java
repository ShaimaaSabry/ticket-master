package shaimaa.ticketmaster.domain.contracts;

import shaimaa.ticketmaster.application.queries.SearchEvents.SearchEventsQuery;
import shaimaa.ticketmaster.domain.model.Event;
import shaimaa.ticketmaster.domain.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EventRepository {
    List<Event> searchEvents(SearchEventsQuery query);
    Optional<Event> getEvent(String showId);

    Set<Ticket> getAvailableTickets(String eventId);
    long getReservedTicketsCount(String eventId);
}
