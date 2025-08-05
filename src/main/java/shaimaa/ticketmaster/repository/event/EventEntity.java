package shaimaa.ticketmaster.repository.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shaimaa.ticketmaster.domain.model.Event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "[event]")
public class EventEntity {
    @Id
    private Long id;

    private String name;

    @ManyToOne
    private PerformerEntity performer;

    private String description;

    @ManyToOne
    private VenueEntity venue;

    @Column(name = "start_time")
    LocalDateTime startTime;

    public static EventEntity from(Event event) {
        return null;
    }

    public Event toEvent() {
        return Event.of(
                this.id,
                this.name,
                this.performer.toPerformer(),
                this.description,
                this.venue.toVenue(),
                this.startTime
        );
    }
}
