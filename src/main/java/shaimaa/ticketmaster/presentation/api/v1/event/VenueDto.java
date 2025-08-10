package shaimaa.ticketmaster.presentation.api.v1.event;

import shaimaa.ticketmaster.model.Venue;

public record VenueDto(
        Long id,
        String name
) {
    public static VenueDto from(Venue venue) {
        return new VenueDto(venue.getId(), venue.getName());
    }
}
