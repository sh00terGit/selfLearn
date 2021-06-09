package by.shipul.stepic.redis.repository;

import by.shipul.stepic.model.Developer;

import java.util.Map;

public interface RedisDeveloperRepository {
    Map<Object, Object> findAll();
    void add(Developer movie);
    void delete(Long id);
    Developer findDeveloperById(Long id);
}