package shaimaa.ticketmaster.contracts;

import java.util.List;

public interface RedisService {
    void rpush(String queueName, String value);
    List<String> getAll(String queueName);
    String lpeek(String queueName);
    String lpop(String queueName);
}
