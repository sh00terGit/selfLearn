package by.shipul.selflearn.feign;

import by.shipul.selflearn.model.Developer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "developer",url = "http://localhost:8080/api/developers")
public interface DeveloperFeignClient {

    @GetMapping("/{id}")
    Developer findById(@RequestHeader("Auth") String token, @PathVariable Long id);
}