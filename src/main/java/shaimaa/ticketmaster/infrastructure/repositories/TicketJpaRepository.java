package shaimaa.ticketmaster.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shaimaa.ticketmaster.infrastructure.repositories.event.EventEntity;

import java.util.Set;

@Repository
public interface TicketJpaRepository extends JpaRepository<TicketEntity, String> {

    Set<TicketEntity> findByShowAndBookingIsNull(EventEntity show);

    @Query("SELECT COUNT(t) FROM TicketEntity t, EventEntity s, BookingEntity b "
            + "WHERE t.show = s "
            + "AND t.booking = b "
            + "AND b.status = 'RESERVED' ")
    long findByShowAndBookingIsReserved(EventEntity show);

//    @Modifying
//    @Query("update ShowTicket t set t.book_id = :booking_id where t.id = :id")
//    void updatePhone(@Param(value = "id") long id, @Param(value = "phone") String booking_id);
}
