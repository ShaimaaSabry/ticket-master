package shaimaa.ticketmaster.domain;

import lombok.Getter;
import lombok.ToString;
import shaimaa.ticketmaster.domain.model.Event;

@Getter
@ToString
public class Ticket {
    private String id;
    private Event event;
    private float price;
    @ToString.Exclude
    private Booking booking;

    public Ticket(String id) {
        this.id = id;
    }

    public Ticket(String id, Event event, float price) {
        this.id = id;
        this.event = event;
        this.price = price;
    }

    public static Ticket from(String id) {
        return new Ticket(id, null, 0);
    }

    void book(Booking booking) {
//        if (booking != null) {
//            throw new IllegalArgumentException();
//        }

        this.booking = booking;
    }
}
