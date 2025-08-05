package shaimaa.ticketmaster.api.v1.event;

public record VenueDto(
        Long id,
        String name
) {
    public static VenueDto from(shaimaa.ticketmaster.domain.model.Venue venue) {
        return new VenueDto(venue.getId(), venue.getName());
    }
}
