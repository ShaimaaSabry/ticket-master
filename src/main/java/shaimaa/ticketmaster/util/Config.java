package shaimaa.ticketmaster.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class Config {

    @Bean
    JedisPool jedisPool() {
        return new JedisPool();
    }
}
