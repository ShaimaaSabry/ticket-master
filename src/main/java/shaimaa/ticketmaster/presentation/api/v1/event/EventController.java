package shaimaa.ticketmaster.presentation.api.v1.event;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shaimaa.ticketmaster.application.queries.GetEvent.GetEventHandler;
import shaimaa.ticketmaster.application.queries.GetEventAvailableTickets.GetEventAvailableTicketsHandler;
import shaimaa.ticketmaster.presentation.api.Wrapper;
import shaimaa.ticketmaster.application.queries.SearchEvents.SearchEventsHandler;
import shaimaa.ticketmaster.application.queries.SearchEvents.SearchEventsQuery;
import shaimaa.ticketmaster.model.Event;
import shaimaa.ticketmaster.model.Ticket;
import shaimaa.ticketmaster.UserWaitingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/events")
@Tag(name = "Events", description = "Search events.")
class EventController {
    private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

    private UserWaitingService userWaitingService;
    private final SearchEventsHandler searchEventsHandler;
    private final GetEventHandler getEventHandler;
    private final GetEventAvailableTicketsHandler getEventAvailableTicketsHandler;

    EventController(
            UserWaitingService userWaitingService,
            SearchEventsHandler searchEventsHandler,
            GetEventHandler getEventHandler,
            GetEventAvailableTicketsHandler getEventAvailableTicketsHandler
    ) {
        this.userWaitingService = userWaitingService;
        this.searchEventsHandler = searchEventsHandler;
        this.getEventHandler = getEventHandler;
        this.getEventAvailableTicketsHandler = getEventAvailableTicketsHandler;
    }

    @GetMapping
    Wrapper<List<EventItemDTO>> searchEvents(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
            Long cityId,
            Long venueId,
            String query
    ) {
        LOG.debug(
                "Parameters received: fromDate={}, toDate={}, cityId={}, venueId={}, query={}",
                fromDate, toDate, cityId, venueId, query
        );
        List<Event> events = this.searchEventsHandler.handle(
                new SearchEventsQuery(
                        fromDate,
                        toDate,
                        cityId,
                        venueId,
                        query
                )
        );

        return new Wrapper<>(
                events
                        .stream()
                        .map(EventItemDTO::from)
                        .toList()
        );
    }

    @GetMapping("{eventId}")
    EventDetailsDto getEvent(
            @PathVariable Long eventId
    ) {
        Event event = this.getEventHandler.handle(eventId);

        return EventDetailsDto.from(event);
    }

    @GetMapping("{eventId}/available-tickets")
    Set<TicketDTO> getAvailableTickets(@PathVariable Long eventId) {
        Set<Ticket> tickets = this.getEventAvailableTicketsHandler.handle(eventId);

        return tickets.stream().map(TicketDTO::from).collect(Collectors.toSet());
    }

//    @PatchMapping("{showId}/:join_waiting_list")
//    void joinWaitingList(@PathVariable String showId) {
//        this.userWaitingService.addUser(showId,"user1");
//    }
}
