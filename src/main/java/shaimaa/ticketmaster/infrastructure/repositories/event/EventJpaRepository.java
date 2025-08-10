package shaimaa.ticketmaster.infrastructure.repositories.event;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
interface EventJpaRepository extends CrudRepository<EventEntity, Long>, JpaSpecificationExecutor<EventEntity> {
    @Query(value = """
        SELECT * 
        FROM event e
        JOIN venue v ON e.venue_id = v.id
        JOIN city c ON v.city_id = c.id
        WHERE e.start_time >= COALESCE(:fromDate, e.start_time)
          AND e.start_time <= COALESCE(:toDate, e.start_time)
          AND (:cityId IS NULL OR c.id = :cityId)
          AND (:venueId IS NULL OR v.id = :venueId)
          AND (:query IS NULL OR LOWER(e.name) LIKE LOWER(CONCAT('%', :query, '%')))
    """, nativeQuery = true)
    List<EventEntity> search(
            @Param("fromDate") LocalDateTime fromDate,
            @Param("toDate") LocalDateTime toDate,
            @Param("cityId") Long cityId,
            @Param("venueId") Long venueId,
            @Param("query") String query
    );
}
