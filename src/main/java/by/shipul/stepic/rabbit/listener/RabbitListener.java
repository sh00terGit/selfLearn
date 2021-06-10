package by.shipul.stepic.rabbit.listener;

import by.shipul.stepic.model.DeveloperStatus;
import by.shipul.stepic.rabbit.config.RabbitConfig;
import org.springframework.stereotype.Service;

@Service
public class RabbitListener {

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveMessageFromQueue(DeveloperStatus developerStatus){
        System.out.println(developerStatus.toString());
    }
}
