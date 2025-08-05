package shaimaa.ticketmaster.domain;

import org.springframework.stereotype.Service;
import shaimaa.ticketmaster.domain.contracts.EventRepository;

import java.util.Set;

@Service
public class ShowService {
    private EventRepository eventRepository;

    ShowService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Set<Ticket> getAvailableTickets(String showId) {
        return eventRepository.getAvailableTickets(showId);
    }
}
