package shaimaa.ticketmaster.api.v1.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shaimaa.ticketmaster.domain.model.Event;
import shaimaa.ticketmaster.domain.model.Performer;
import shaimaa.ticketmaster.domain.model.Venue;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class EventDTO {
    private Long id;
    private String name;
    private PerformerDto performer;
    private VenueDto venue;
    private LocalDateTime startTime;

    public static EventDTO from(Event event) {
        return new EventDTO(
                event.getId(),
                event.getName(),
                PerformerDto.from(event.getPerformer()),
                VenueDto.from(event.getVenue()),
                event.getStartTime()
        );
    }
}
