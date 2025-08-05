package shaimaa.ticketmaster.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class Event {
    private Long id;
    private String name;
    private Performer performer;
    private String description;
    private Venue venue;
    private LocalDateTime startTime;

    public static Event of(
            Long id,
            String name,
            Performer performer,
            String description,
            Venue venue,
            LocalDateTime startTime
    ) {
        return new Event(id, name, performer, description, venue, startTime);
    }

}
