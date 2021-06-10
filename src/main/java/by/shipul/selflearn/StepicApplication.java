package by.shipul.selflearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StepicApplication {

    public static void main(String[] args) {
        SpringApplication.run(StepicApplication.class, args);
    }

}
