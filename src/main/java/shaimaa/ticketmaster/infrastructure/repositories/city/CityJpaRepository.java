package shaimaa.ticketmaster.infrastructure.repositories.city;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
interface CityJpaRepository extends CrudRepository<CityEntity, String> {
    Set<CityEntity> findAll();
}
