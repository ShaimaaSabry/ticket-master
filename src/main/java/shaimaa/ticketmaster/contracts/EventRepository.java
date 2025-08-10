package shaimaa.ticketmaster.contracts;

import shaimaa.ticketmaster.application.queries.SearchEvents.SearchEventsQuery;
import shaimaa.ticketmaster.model.Event;
import shaimaa.ticketmaster.model.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EventRepository {
    List<Event> searchEvents(SearchEventsQuery query);
    Optional<Event> getEvent(long eventId);
    Set<Ticket> getAvailableTickets(long eventId, int reservedWaitTimeInMinutes);

    long getReservedTicketsCount(Long eventId);
}
