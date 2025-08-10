package shaimaa.ticketmaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Performer {
    private Long id;
    private String name;

    public static Performer of(Long id, String name) {
        return new Performer(id, name);
    }
}
