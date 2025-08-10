package shaimaa.ticketmaster.presentation.api.v1.event;

import shaimaa.ticketmaster.model.Event;

import java.time.LocalDateTime;

public record EventItemDTO (
    Long id,
    String name,
    String imageUrl,
    PerformerDto performer,
    VenueDto venue,
    LocalDateTime startTime

) {
    public static EventItemDTO from(Event event) {
        return new EventItemDTO(
                event.getId(),
                event.getName(),
                event.getImageUrl(),
                PerformerDto.from(event.getPerformer()),
                VenueDto.from(event.getVenue()),
                event.getStartTime()
        );
    }
}
