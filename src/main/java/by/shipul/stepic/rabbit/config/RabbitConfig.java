package by.shipul.stepic.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *Запустить в докере кролика и редис ( или удалить пакет с редисом)
 *
 * Кролик
 *docker run -d --rm --name rabbit --network=host rabbitmq:latest
 *docker exec -it 9a54 bash
 * root@andrey-notebook:/# rabbitmq-plugins enable rabbitmq_management
 * 
 *
 * Редиска
 *docker run -d --rm --name redis --network=host redis:alpine3.13
 *
 */
@Configuration
public class RabbitConfig {

    public static final String EXCHANGE_NAME = "developer_exchange";
    public static final String ROUTING_KEY = "developer_routing";
    public static final String QUEUE_NAME = "developer_queue";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with(ROUTING_KEY);
    }

    @Bean
    CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("127.0.0.1");
    }

    @Bean
    AmqpTemplate amqpTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory());
        rabbitTemplate.setReplyTimeout(2000);
        rabbitTemplate.setRoutingKey(ROUTING_KEY);
        rabbitTemplate.setExchange(EXCHANGE_NAME);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }


}
