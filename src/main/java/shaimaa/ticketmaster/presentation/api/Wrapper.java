package shaimaa.ticketmaster.presentation.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wrapper<T> {
    T data;
}
