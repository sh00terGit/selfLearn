package by.shipul.stepic.redis.publish;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
public class MessagePublisherImpl implements MessagePublisher {

    private final RedisTemplate<String,Object> redisTemplate;
    private final ChannelTopic channelTopic;

    @Override
    public void publish(String message) {
        log.info("publish message " + message);
        redisTemplate.convertAndSend(channelTopic.getTopic(),message);
    }
}
