package shaimaa.ticketmaster.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Id;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private String id;
}
