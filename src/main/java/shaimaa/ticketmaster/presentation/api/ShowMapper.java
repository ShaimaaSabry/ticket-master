package shaimaa.ticketmaster.presentation.api;

import org.mapstruct.Mapper;
import shaimaa.ticketmaster.presentation.api.v1.event.EventItemDTO;
import shaimaa.ticketmaster.model.Event;

@Mapper(componentModel = "spring")
public interface ShowMapper {
    EventItemDTO map(Event event);
}
