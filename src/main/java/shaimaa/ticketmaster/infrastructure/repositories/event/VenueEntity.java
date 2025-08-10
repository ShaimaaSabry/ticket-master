package shaimaa.ticketmaster.infrastructure.repositories.event;

import lombok.Data;
import shaimaa.ticketmaster.model.Venue;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import shaimaa.ticketmaster.infrastructure.repositories.city.CityEntity;

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
