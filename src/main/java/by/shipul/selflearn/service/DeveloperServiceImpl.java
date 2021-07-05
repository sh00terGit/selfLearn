package by.shipul.selflearn.service;

import by.shipul.selflearn.model.Developer;
import by.shipul.selflearn.model.DeveloperStatus;
import by.shipul.selflearn.rabbit.listener.QueueListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeveloperServiceImpl implements DeveloperService{

    private final QueueListener listener;

    @Override
    @SendTo(QueueListener.DEVELOPER_ROUTING)
    public void notifyAboutDeveloperStatus(Developer developer, DeveloperStatus status) {
        log.info("--------------------------SENDING MESSAGE----------------------------");
        log.info(developer.toString());
        log.info(status.toString());
        listener.pushDevelopers().send(MessageBuilder.withPayload(status).build());
        log.info("----------------------------------------------------------------------");
    }

    /*
    *     @SendTo(QueueListener.NEW_DOCS_TO_TASK_API)
    public void notifyAboutNewDocuments(Object o) {
        listener.notifyAboutNewDocuments().send(MessageBuilder.withPayload(o).build());
    }
    * */
}
