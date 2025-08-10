package shaimaa.ticketmaster;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import jakarta.persistence.Id;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String id;
}
