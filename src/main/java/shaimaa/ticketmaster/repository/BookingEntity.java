package shaimaa.ticketmaster.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import shaimaa.ticketmaster.domain.Booking;
import shaimaa.ticketmaster.domain.BookingStatus;
import shaimaa.ticketmaster.domain.Ticket;
import shaimaa.ticketmaster.repository.event.EventEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    private String id;

    @Column(name = "[createdOn]")
    private LocalDateTime createdOn;

    @ManyToOne
//    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    private EventEntity show;

    @ToString.Exclude
    @OneToMany
    private Set<TicketEntity> tickets;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    static BookingEntity from(Booking booking) {
        return new BookingEntity(
                booking.getId(),
                booking.getCreatedOn(),
                UserEntity.from(booking.getUser()),
                EventEntity.from(booking.getEvent()),
                null,
                booking.getStatus()
        );
    }

    Booking toBooking() {
        System.out.println(this.tickets);
        return new Booking(
                this.id,
                this.createdOn,
                null,
                this.show.toEvent(),
                this.tickets.stream().map(t -> t.toTicket()).toArray(Ticket[]::new),
                this.status);
    }
}
