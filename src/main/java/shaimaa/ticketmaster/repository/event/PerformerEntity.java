package shaimaa.ticketmaster.repository.event;

import lombok.Data;
import shaimaa.ticketmaster.domain.model.Performer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
