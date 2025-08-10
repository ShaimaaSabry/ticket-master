package shaimaa.ticketmaster.infrastructure.repositories.event;

import lombok.Data;
import shaimaa.ticketmaster.model.Performer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "[performer]")
public class PerformerEntity {
    @Id
    private Long id;

    private String name;

    Performer toPerformer() {
        return Performer.of(this.id, this.name);
    }
}
