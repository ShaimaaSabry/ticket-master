package shaimaa.ticketmaster.application.queries.SearchEvents;

import org.springframework.stereotype.Component;
import shaimaa.ticketmaster.model.Event;
import shaimaa.ticketmaster.contracts.EventRepository;

import java.util.List;

@Component
public class SearchEventsHandler {
    private final EventRepository eventRepository;

    SearchEventsHandler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> handle(SearchEventsQuery query) {
        return this.eventRepository.searchEvents(query);
    }
}
