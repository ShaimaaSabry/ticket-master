package shaimaa.ticketmaster.repository.event;

import lombok.Data;
import shaimaa.ticketmaster.domain.model.Venue;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "[venue]")
public class VenueEntity {
    @Id
    private Long id;

    private String name;

    @ManyToOne
    private CityEntity city;

    Venue toVenue() {
        return Venue.of(this.id, this.name);
    }
}
