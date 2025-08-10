package shaimaa.ticketmaster.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class City {
    private String id;
    private String name;
    private String country;

    public static City of(String id, String name, String country) {
        return new City(id, name, country);
    }
}
