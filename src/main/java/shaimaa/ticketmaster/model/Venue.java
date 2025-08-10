package shaimaa.ticketmaster.model;

import lombok.Data;

@Data
public class Venue {
    private Long id;
    private String name;

    public static Venue of(Long id, String name) {
        Venue venue = new Venue();
        venue.id = id;
        venue.name = name;
        return venue;
    }
}
