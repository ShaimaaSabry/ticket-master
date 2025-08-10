package shaimaa.ticketmaster.application.queries.GetCities;

import org.springframework.stereotype.Component;
import shaimaa.ticketmaster.model.City;
import shaimaa.ticketmaster.contracts.CityRepository;

import java.util.Set;

@Component
public class GetCitiesHandler {
    private final CityRepository cityRepository;

    public GetCitiesHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Set<City> handle() {
        return this.cityRepository.getAll();
    }
}
