package by.shipul.stepic.redis.config;

import by.shipul.stepic.redis.publish.MessagePublisher;
import by.shipul.stepic.redis.publish.MessagePublisherImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        /*JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(
                new RedisStandaloneConfiguration("127.0.0.0", 6379));*/
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String,Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }

    @Bean
    MessagePublisher redisPublisher() {
        return new MessagePublisherImpl(redisTemplate(), topic());
    }

    private ChannelTopic topic() {
        return new ChannelTopic("test-topic");
    }

}
