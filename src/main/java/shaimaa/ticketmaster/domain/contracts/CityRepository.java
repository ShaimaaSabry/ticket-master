package shaimaa.ticketmaster.domain.contracts;

import shaimaa.ticketmaster.domain.model.City;

import java.util.Set;

public interface CityRepository {
    Set<City> getAll();
}
