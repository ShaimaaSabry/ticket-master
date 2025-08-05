package shaimaa.ticketmaster.application.queries.SearchEvents;

import java.time.LocalDate;

public record SearchEventsQuery(
        LocalDate fromDate,
        LocalDate toDate,
        Long cityId,
        Long venueId,
        String query
) {
}
