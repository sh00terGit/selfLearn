package by.shipul.selflearn.controller;

import by.shipul.selflearn.model.Developer;
import by.shipul.selflearn.redis.repository.RedisDeveloperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
//@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperRestController {

    public static List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L,"User","Userov"),
            new Developer(2L,"Admin","Adminov"),
            new Developer(3L,"Maksim","Maksimov"),
            new Developer(4L,"Andrey","Andreev")
    ).collect(Collectors.toList());

    private final RedisDeveloperRepository repository;

    @PostConstruct
    private void init(){
        DEVELOPERS.forEach(repository::add);
    }

    @GetMapping
    public Map<Object,Object> getAll() {
        return repository.findAll();

    }

    @GetMapping("/{id}")
    public Developer getById(@RequestHeader("Auth") String token, @PathVariable Long id) {
        log.info(token);
        return repository.findDeveloperById(id);
     /*   return developers.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);*/
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer){
        repository.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
       /* developers.removeIf(developer -> developer.getId().equals(id));*/
        repository.delete(id);
    }

}
