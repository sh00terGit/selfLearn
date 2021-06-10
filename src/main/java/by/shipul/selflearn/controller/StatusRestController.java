package by.shipul.selflearn.controller;

import by.shipul.selflearn.feign.DeveloperFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/status")
public class StatusRestController {

    private final DeveloperFeignClient developerFeignClient;

    @GetMapping("/developer/{id}")
    public ResponseEntity<?> getDevelopersFromOther(@PathVariable Long id){
        return ResponseEntity.ok(developerFeignClient.findById("my-token",id));
    }
}
