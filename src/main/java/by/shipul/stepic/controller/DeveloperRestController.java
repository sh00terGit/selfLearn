package by.shipul.stepic.controller;

import by.shipul.stepic.model.Developer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequestMapping("/api/developers")
public class DeveloperRestController {

    private List<Developer> developers = Stream.of(
            new Developer(1L,"User","Userov"),
            new Developer(2L,"Admin","Adminov"),
            new Developer(3L,"Maksim","Maksimov"),
            new Developer(4L,"Andrey","Andreev")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return developers;
    }

    @GetMapping("/{id}")
    public Developer getById(@RequestHeader("Auth") String token, @PathVariable Long id) {
        log.info(token);
        return developers.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer){
        developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        developers.removeIf(developer -> developer.getId().equals(id));
    }

}
