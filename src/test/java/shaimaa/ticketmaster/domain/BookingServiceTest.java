package shaimaa.ticketmaster.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shaimaa.ticketmaster.repository.BookingEntity;
import shaimaa.ticketmaster.repository.event.EventEntity;

@SpringBootTest
class BookingServiceTest {
    @Autowired
    private BookingService bookingService;


    @Test
    void thenExpireBookings() {
        // GIVEN
        EventEntity eventEntity = null;
        BookingEntity bookingEntity = null;

        // WHEN
        bookingService.expireBookings("1");

        // THEN
    }
}
