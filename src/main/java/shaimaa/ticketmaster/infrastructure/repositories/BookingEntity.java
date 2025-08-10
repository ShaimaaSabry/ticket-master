package shaimaa.ticketmaster.infrastructure.repositories;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import shaimaa.ticketmaster.Booking;
import shaimaa.ticketmaster.BookingStatus;
import shaimaa.ticketmaster.model.Ticket;
import shaimaa.ticketmaster.infrastructure.repositories.event.EventEntity;


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
