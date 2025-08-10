package shaimaa.ticketmaster.infrastructure.repositories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shaimaa.ticketmaster.model.Ticket;
import shaimaa.ticketmaster.infrastructure.repositories.event.EventEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "[Ticket]")
public class TicketEntity {
    @Id
    private Long id;

    @ManyToOne
    private EventEntity show;

    private float price;

    @ManyToOne(cascade = CascadeType.ALL)
    private BookingEntity booking;

    Ticket toTicket() {
        return Ticket.of(this.id);
    }
}
