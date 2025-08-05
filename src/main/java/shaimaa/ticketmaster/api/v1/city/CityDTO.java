package shaimaa.ticketmaster.api.v1.city;

import shaimaa.ticketmaster.domain.model.City;

public record CityDTO (
    String id,
    String name,
    String country
) {
    static CityDTO from(City city) {
        return new CityDTO(city.getId(), city.getName(), city.getCountry());
    }
}
