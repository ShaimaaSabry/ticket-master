package shaimaa.ticketmaster.infrastructure.repositories.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shaimaa.ticketmaster.model.City;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "[city]")
public class CityEntity {
    @Id
    private String id;

    private String name;

//    private String country;

    public static CityEntity from(City city) {
        return new CityEntity(city.getId(), city.getName());
    }
}
