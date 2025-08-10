package shaimaa.ticketmaster.model;

import lombok.Getter;
import lombok.ToString;
import shaimaa.ticketmaster.Booking;

@Getter
@ToString
public class Ticket {
    private Long id;

//    private Event event;
//    private float price;

//    @ToString.Exclude
//    private Booking booking;

    private Ticket(
            Long id
    ) {
        this.id = id;
    }

    public static Ticket of(Long id) {
        return new Ticket(id);
    }

    void book(Booking booking) {
//        if (booking != null) {
//            throw new IllegalArgumentException();
//        }

//        this.booking = booking;
    }
}
