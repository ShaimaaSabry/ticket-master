package shaimaa.ticketmaster.util;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import shaimaa.ticketmaster.contracts.RedisService;

import java.util.List;

@Service
class RedisServiceImpl implements RedisService {
    private final JedisPool jedisPool;

    RedisServiceImpl(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
    @Override
    public void rpush(String queueName, String value) {
        try(Jedis jedis = jedisPool.getResource()) {
            jedis.rpush(queueName, value);
        }
    }

    @Override
    public List<String> getAll(String queueName) {
        return null;
    }

    @Override
    public String lpeek(String queueName) {
        try(Jedis jedis = jedisPool.getResource()) {
            List<String> range = jedis.lrange(queueName, 0, 0);
            if (range.size() == 0) {
                return null;
            }
            return range.get(0);
        }
    }

    @Override
    public String lpop(String queueName) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.lpop(queueName);
        }
    }
}
