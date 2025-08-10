package shaimaa.ticketmaster.infrastructure.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shaimaa.ticketmaster.BookingStatus;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
interface BookingSqlRepository extends CrudRepository<BookingEntity, String> {
    Set<BookingEntity> findAllByStatusAndCreatedOnLessThan(BookingStatus status, LocalDateTime expirationDateTime);
}
