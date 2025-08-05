package shaimaa.ticketmaster.api;

import org.mapstruct.Mapper;
import shaimaa.ticketmaster.api.v1.event.EventDTO;
import shaimaa.ticketmaster.domain.model.Event;

@Mapper(componentModel = "spring")
public interface ShowMapper {
    EventDTO map(Event event);
}
