package shaimaa.ticketmaster.api.v1.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shaimaa.ticketmaster.api.Wrapper;
import shaimaa.ticketmaster.application.queries.SearchEvents.SearchEventsHandler;
import shaimaa.ticketmaster.application.queries.SearchEvents.SearchEventsQuery;
import shaimaa.ticketmaster.domain.model.Event;
import shaimaa.ticketmaster.domain.ShowService;
import shaimaa.ticketmaster.domain.Ticket;
import shaimaa.ticketmaster.domain.UserWaitingService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/events")
class EventController {
    private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

    private ShowService showService;
    private UserWaitingService userWaitingService;
    private SearchEventsHandler searchEventsHandler;

    EventController(
            ShowService showService,
            UserWaitingService userWaitingService,
            SearchEventsHandler searchEventsHandler) {
        this.showService = showService;
        this.userWaitingService = userWaitingService;
        this.searchEventsHandler = searchEventsHandler;
    }

    @GetMapping
    Wrapper<List<EventDTO>> searchEvents(
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
                        .map(EventDTO::from)
                        .toList()
        );
    }

    @GetMapping("{eventId}/available-tickets")
    Set<TicketDTO> getAvailableTickets(@PathVariable String eventId) {
        Set<Ticket> tickets = showService.getAvailableTickets(eventId);

        return tickets.stream().map(TicketDTO::from).collect(Collectors.toSet());
    }

    @PatchMapping("{showId}/:join_waiting_list")
    void joinWaitingList(@PathVariable String showId) {
        this.userWaitingService.addUser(showId,"user1");
    }
}
