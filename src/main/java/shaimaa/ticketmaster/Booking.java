package shaimaa.ticketmaster;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import shaimaa.ticketmaster.model.Event;
import shaimaa.ticketmaster.model.Ticket;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class Booking {
    private String id;
    private LocalDateTime createdOn;
    private User user;
    private Event event;
    private Ticket[] tickets;
    private BookingStatus status;

    public static Booking from(String userId, Long showId, Ticket[] tickets) {
        return new Booking(
          null,
          LocalDateTime.now(),
          new User(userId),
          null,
          tickets,
          BookingStatus.RESERVED
        );
    }

    public void purchase() {
        this.status = BookingStatus.PURCHASED;
    }

    public void cancel() {
        this.status = BookingStatus.EXPIRED;
    }
}
