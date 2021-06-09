package by.shipul.stepic.redis.repository;

import by.shipul.stepic.model.Developer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RedisDeveloperRepositoryImpl implements RedisDeveloperRepository {

    private static final String KEY = "Developer";
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @PostConstruct
    private void initHashOperations(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<Object, Object> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void add(Developer developer) {
        hashOperations.putIfAbsent(KEY,developer.getId(),developer);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(KEY,id);
    }

    @Override
    public Developer findDeveloperById(Long id) {
        return (Developer) hashOperations.get(KEY,id);
    }
}
