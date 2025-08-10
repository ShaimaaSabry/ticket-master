package shaimaa.ticketmaster.infrastructure.repositories.event;

import org.springframework.stereotype.Component;
import shaimaa.ticketmaster.application.queries.SearchEvents.SearchEventsQuery;
import shaimaa.ticketmaster.model.Event;
import shaimaa.ticketmaster.model.Ticket;
import shaimaa.ticketmaster.contracts.EventRepository;
import shaimaa.ticketmaster.infrastructure.repositories.TicketJpaRepository;

import jakarta.persistence.criteria.Predicate;
import java.time.LocalTime;
import java.util.*;

@Component
class EventSqlRepositoryImpl implements EventRepository {
    private final EventJpaRepository eventJpaRepository;
    private final TicketJpaRepository ticketJpaRepository;

    EventSqlRepositoryImpl(
            EventJpaRepository eventJpaRepository,
            TicketJpaRepository ticketJpaRepository) {
        this.eventJpaRepository = eventJpaRepository;
        this.ticketJpaRepository = ticketJpaRepository;
    }

    @Override
    public List<Event> searchEvents(SearchEventsQuery query) {
//        List<EventEntity> eventEntities = eventJpaRepository.search(
//                query.fromDate() != null ? query.fromDate().atStartOfDay() : null,
//                query.toDate() != null ? query.toDate().atTime(LocalTime.MAX) : null,
//                query.cityId(),
//                query.venueId(),
//                query.query()
//        );

        List<EventEntity> eventEntities = searchEventsUsingCriteriaBuilder(query);

        return eventEntities
                .stream()
                .map(EventEntity::toEvent)
                .toList();
    }

    @Override
    public Optional<Event> getEvent(long eventId) {
        return eventJpaRepository.findById(eventId)
                .map(EventEntity::toEvent);
    }

    @Override
    public Set<Ticket> getAvailableTickets(long eventId, int reservedWaitTimeInMinutes) {
        return Set.of();
    }

    private List<EventEntity> searchEventsUsingCriteriaBuilder(SearchEventsQuery query) {
        return eventJpaRepository.findAll(
                (root, cq, cb) -> {
                    List<Predicate> predicates = new ArrayList<>();

                    if (query.fromDate() != null) {
                        predicates.add(
                                cb.greaterThanOrEqualTo(
                                        root.get("startTime"),
                                        query.fromDate().atStartOfDay()
                                )
                        );
                    }
                    if (query.toDate() != null) {
                        predicates.add(
                                cb.lessThanOrEqualTo(
                                        root.get("startTime"),
                                        query.toDate().atTime(LocalTime.MAX)
                                )
                        );
                    }
                    if (query.cityId() != null) {
                        predicates.add(
                                cb.equal(
                                        root.get("venue").get("city").get("id"),
                                        query.cityId()
                                )
                        );
                    }
                    if (query.venueId() != null) {
                        predicates.add(
                                cb.equal(
                                        root.get("venue").get("id"),
                                        query.venueId()
                                )
                        );
                    }
                    if (query.query() != null && !query.query().isEmpty()) {
                        predicates.add(
                                cb.like(
                                        cb.lower(root.get("name")),
                                        "%" + query.query().toLowerCase() + "%"
                                )
                        );
                    }

                    return cb.and(predicates.toArray(new Predicate[0]));
                });
    }

//    @Override
    public Set<Ticket> getAvailableTickets(String eventId) {
//        Optional<EventEntity> showEntity = eventJpaRepository.findById(eventId);
//        if(showEntity.isEmpty()) {
//            throw new IllegalArgumentException("Show does not exist.");
//        }

//        Set<TicketEntity> ticketEntities = ticketJpaRepository.findByShowAndBookingIsNull(showEntity.get());

//        return ticketEntities
//                .stream()
//                .map(t -> new Ticket(
//                        t.getId(),
//                        new Event(
//                                t.getShow().getId(),
//                                t.getShow().getName(),
//                                City.from(
//                                        t.getShow().getCity().getId(),
//                                        t.getShow().getCity().getName(),
//                                        t.getShow().getCity().getCountry()
//                                )
//                        ),
//                        t.getPrice()))
//                .collect(Collectors.toSet());

        return null;
    }

    @Override
    public long getReservedTicketsCount(final Long eventId) {
        Optional<EventEntity> showEntity = eventJpaRepository.findById(eventId);
        if (showEntity.isEmpty()) {
            throw new IllegalArgumentException("Invalid showId");
        }

        return ticketJpaRepository.findByShowAndBookingIsReserved(showEntity.get());
    }

}
