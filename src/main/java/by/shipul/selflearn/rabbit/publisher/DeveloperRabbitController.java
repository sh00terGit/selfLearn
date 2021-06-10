package by.shipul.selflearn.rabbit.publisher;

import by.shipul.selflearn.model.Developer;
import by.shipul.selflearn.model.DeveloperStatus;
import by.shipul.selflearn.rabbit.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/rabbit/developers")
@RequiredArgsConstructor
public class DeveloperRabbitController {

    private final RabbitTemplate template;

    @PostMapping("/{company}")
    public Developer createDeveloper(@RequestBody Developer developer,@PathVariable String company){
        DeveloperStatus order = new DeveloperStatus(developer,"PROCESS","developer placed into company " + company);
        template.convertAndSend(RabbitConfig.EXCHANGE_NAME,RabbitConfig.ROUTING_KEY,order);
        return developer;
    }


}
