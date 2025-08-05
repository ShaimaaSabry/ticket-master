package shaimaa.ticketmaster.api;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import shaimaa.ticketmaster.api.v1.event.EventDTO;
import shaimaa.ticketmaster.api.v1.event.PerformerDto;
import shaimaa.ticketmaster.api.v1.event.VenueDto;
import shaimaa.ticketmaster.domain.model.Event;
import shaimaa.ticketmaster.domain.model.Performer;
import shaimaa.ticketmaster.domain.model.Venue;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-08T10:43:42+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.4.jar, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ShowMapperImpl implements ShowMapper {

    @Override
    public EventDTO map(Event event) {
        if ( event == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        PerformerDto performer = null;
        VenueDto venue = null;
        LocalDateTime startTime = null;

        id = event.getId();
        name = event.getName();
        performer = performerToPerformerDto( event.getPerformer() );
        venue = venueToVenueDto( event.getVenue() );
        startTime = event.getStartTime();

        EventDTO eventDTO = new EventDTO( id, name, performer, venue, startTime );

        return eventDTO;
    }

    protected PerformerDto performerToPerformerDto(Performer performer) {
        if ( performer == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = performer.getId();
        name = performer.getName();

        PerformerDto performerDto = new PerformerDto( id, name );

        return performerDto;
    }

    protected VenueDto venueToVenueDto(Venue venue) {
        if ( venue == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = venue.getId();
        name = venue.getName();

        VenueDto venueDto = new VenueDto( id, name );

        return venueDto;
    }
}
