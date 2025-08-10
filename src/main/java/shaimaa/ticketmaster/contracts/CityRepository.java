package shaimaa.ticketmaster.contracts;

import shaimaa.ticketmaster.model.City;

import java.util.Set;

public interface CityRepository {
    Set<City> getAll();
}
