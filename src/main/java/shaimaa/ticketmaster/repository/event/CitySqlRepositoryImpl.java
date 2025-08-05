package shaimaa.ticketmaster.repository.event;

import org.springframework.stereotype.Component;
import shaimaa.ticketmaster.domain.model.City;
import shaimaa.ticketmaster.domain.contracts.CityRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CitySqlRepositoryImpl implements CityRepository {
    private final CityJpaRepository cityJpaRepository;

    CitySqlRepositoryImpl(CityJpaRepository cityJpaRepository) {
        this.cityJpaRepository = cityJpaRepository;
    }

    @Override
    public Set<City> getAll() {
        Set<CityEntity> cityEntities = this.cityJpaRepository.findAll();
        return cityEntities
                .stream()
                .map(c -> City.of(c.getId(), c.getName(), null))
                .collect(Collectors.toSet());
    }
}
