package shaimaa.ticketmaster.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shaimaa.ticketmaster.domain.Ticket;
import shaimaa.ticketmaster.repository.event.EventEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "[Ticket]")
public class TicketEntity {
    @Id
    private String id;

    @ManyToOne
    private EventEntity show;

    private float price;

    @ManyToOne(cascade = CascadeType.ALL)
    private BookingEntity booking;

    Ticket toTicket() {
        return new Ticket(this.id, null, this.price);
    }
}
