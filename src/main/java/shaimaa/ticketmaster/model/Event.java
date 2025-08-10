package shaimaa.ticketmaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Event {
    private Long id;
    private String name;
    private String imageUrl;
    private Performer performer;
    private String description;
    private Venue venue;
    private LocalDateTime startTime;
    private List<TicketCategory> ticketCategories;

    public static Event of(
            Long id,
            String name,
            String imageUrl,
            Performer performer,
            String description,
            Venue venue,
            LocalDateTime startTime,
            List<TicketCategory> ticketCategories
    ) {
        return new Event(
                id,
                name,
                imageUrl,
                performer,
                description,
                venue,
                startTime,
                ticketCategories
        );
    }

}
