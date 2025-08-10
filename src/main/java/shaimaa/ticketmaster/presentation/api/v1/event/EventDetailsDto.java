package shaimaa.ticketmaster.presentation.api.v1.event;

import shaimaa.ticketmaster.model.Event;

import java.time.LocalDateTime;
import java.util.List;

record EventDetailsDto(
        Long id,
        String name,
        String imageUrl,
        PerformerDto performer,
        String description,
        VenueDto venue,
        LocalDateTime startTime,
        List<TicketCategoryDto> ticketCategories

) {
    public static EventDetailsDto from(Event event) {
        return new EventDetailsDto(
                event.getId(),
                event.getName(),
                event.getImageUrl(),
                PerformerDto.from(event.getPerformer()),
                event.getDescription(),
                VenueDto.from(event.getVenue()),
                event.getStartTime(),
                event.getTicketCategories().stream()
                        .map(TicketCategoryDto::from)
                        .toList()
        );
    }
}
