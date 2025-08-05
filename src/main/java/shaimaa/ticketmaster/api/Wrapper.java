package shaimaa.ticketmaster.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wrapper<T> {
    T data;
}
