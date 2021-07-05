package by.shipul.selflearn.rabbit.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface QueueListener {

    String DEVELOPER_ROUTING = "developer_routing";

    @Output(QueueListener.DEVELOPER_ROUTING)
    MessageChannel pushDevelopers();

    @Input(QueueListener.DEVELOPER_ROUTING)
    MessageChannel pullDevelopers();


}
