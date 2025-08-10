package shaimaa.ticketmaster.infrastructure.repositories.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import shaimaa.ticketmaster.model.TicketCategory;

@Data
@Entity
@Table(name = "[ticket_category]")
public class TicketCategoryEntity {
    @Id
    private Long id;

    @ManyToOne
    private EventEntity event;

    private String name;

    private Double price;

    TicketCategory toDomain() {
        return TicketCategory.of(
                this.id,
                this.name,
                this.price
        );
    }
}
