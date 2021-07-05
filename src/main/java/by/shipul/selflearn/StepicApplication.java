package by.shipul.selflearn;

import by.shipul.selflearn.rabbit.listener.QueueListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableFeignClients
@EnableBinding(QueueListener.class)
public class StepicApplication {

    public static void main(String[] args) {
        SpringApplication.run(StepicApplication.class, args);
    }

}
