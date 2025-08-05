package shaimaa.ticketmaster.repository.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shaimaa.ticketmaster.domain.model.City;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
