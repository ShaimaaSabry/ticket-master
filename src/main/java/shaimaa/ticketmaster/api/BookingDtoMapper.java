package shaimaa.ticketmaster.api;

import org.mapstruct.Mapper;
import shaimaa.ticketmaster.domain.Booking;

@Mapper(componentModel = "spring")
interface BookingDtoMapper {
    BookingResponseDTO map(Booking booking);
}
