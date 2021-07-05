package by.shipul.selflearn.rabbit.publisher;

import by.shipul.selflearn.model.Developer;
import by.shipul.selflearn.model.DeveloperStatus;
import by.shipul.selflearn.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("/api/rabbit/developers")
@RequiredArgsConstructor
public class DeveloperRabbitController {


    public static List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L,"User","Userov"),
            new Developer(2L,"Admin","Adminov"),
            new Developer(3L,"Maksim","Maksimov"),
            new Developer(4L,"Andrey","Andreev")
    ).collect(Collectors.toList());

    private final DeveloperService service;

    @SneakyThrows
    @GetMapping("/{id}/{company}")
    public DeveloperStatus createDeveloper(@PathVariable String id,@PathVariable String company){
        Developer developer = DEVELOPERS.stream().filter(dev -> dev.getId().toString().equals(id)).findAny().orElseThrow(AttributeNotFoundException::new);
        DeveloperStatus order = new DeveloperStatus(developer,"PROCESS","developer placed into company " + company);
        service.notifyAboutDeveloperStatus(developer,order);
        return order;
    }


}
