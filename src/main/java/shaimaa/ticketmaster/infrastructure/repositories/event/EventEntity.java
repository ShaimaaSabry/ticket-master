package shaimaa.ticketmaster.infrastructure.repositories.event;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shaimaa.ticketmaster.model.Event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "[event]")
public class EventEntity {
    @Id
    private Long id;

    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    private PerformerEntity performer;

    private String description;

    @ManyToOne
    private VenueEntity venue;

    @Column(name = "start_time")
    LocalDateTime startTime;

    @OneToMany(mappedBy = "event")
    private List<TicketCategoryEntity> ticketCategories;

    public static EventEntity from(Event event) {
        return null;
    }

    public Event toEvent() {
        return Event.of(
                this.id,
                this.name,
                this.imageUrl,
                this.performer.toPerformer(),
                this.description,
                this.venue.toVenue(),
                this.startTime,
                this.ticketCategories.stream().map(TicketCategoryEntity::toDomain).toList()
        );
    }
}
