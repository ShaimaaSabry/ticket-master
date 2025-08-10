package shaimaa.ticketmaster.presentation.api;

import org.mapstruct.Mapper;
import shaimaa.ticketmaster.Booking;

@Mapper(componentModel = "spring")
interface BookingDtoMapper {
    BookingResponseDTO map(Booking booking);
}
