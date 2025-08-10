package shaimaa.ticketmaster;

import org.springframework.stereotype.Service;
import shaimaa.ticketmaster.contracts.RedisService;
import shaimaa.ticketmaster.contracts.EventRepository;

@Service
public class UserWaitingService {
    private EventRepository eventRepository;
    private final RedisService redisService;

    UserWaitingService(
            EventRepository eventRepository,
            RedisService redisService) {
        this.eventRepository = eventRepository;
        this.redisService = redisService;
    }

    public long getReservedTicketCount(Long showId) {
        return this.eventRepository.getReservedTicketsCount(showId);
    }

    public void addUser(Long showId, String userId) {
        if (this.eventRepository.getReservedTicketsCount(showId) == 0) {
            throw new IllegalArgumentException("Show does not have a waiting list.");
        }

        String queueName = formatQueueName(showId.toString());
        redisService.rpush(queueName, userId);
    }

    public void notifyUsers(Long showId) {
//        List<String>
    }

    public void expireUsers() {

    }

    private String formatQueueName(String showId) {
        return showId;
    }
}
