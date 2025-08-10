package shaimaa.ticketmaster.application.queries.GetEvent;

import org.springframework.stereotype.Component;
import shaimaa.ticketmaster.contracts.EventRepository;
import shaimaa.ticketmaster.model.Event;

@Component
public class GetEventHandler {
    private final EventRepository eventRepository;

    public GetEventHandler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event handle(Long eventId) {
        return this.eventRepository.getEvent(eventId).orElseThrow(
                () -> new IllegalArgumentException("Event with ID " + eventId + " not found")
        );
    }
}
