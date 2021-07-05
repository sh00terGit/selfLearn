package by.shipul.selflearn.rabbit.listener;

import by.shipul.selflearn.model.DeveloperStatus;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RabbitListener {


    @StreamListener(QueueListener.DEVELOPER_ROUTING)
    public void receiveMessageFromQueue(DeveloperStatus developerStatus, org.springframework.messaging.Message<?> message){
        printMessage(message) ;
        printDTO(developerStatus);

    }

    private void printDTO(DeveloperStatus developerStatus) {
        System.out.println("--------------DTO------------------");
        System.out.println(developerStatus.toString());
        System.out.println("--------------------------------------");
    }

    private void printMessage(org.springframework.messaging.Message<?> message) {
        System.out.println("--------------MESSAGE FROM QUEUE------------------");
        System.out.println(message);
        System.out.println("--------------KEY SET------------------");
        System.out.println(message.getHeaders().keySet());

        Message amqpMessage = message.getHeaders().get("sourceData", Message.class);
        if(Objects.nonNull(amqpMessage)) {
            System.out.println("QUEUE----------------");
            String consumerQueue = amqpMessage.getMessageProperties().getConsumerQueue();
            System.out.println(consumerQueue);
        }
    }
}
