package by.shipul.selflearn.redis.repository;

import by.shipul.selflearn.model.Developer;

import java.util.Map;

public interface RedisDeveloperRepository {
    Map<Object, Object> findAll();
    void add(Developer movie);
    void delete(Long id);
    Developer findDeveloperById(Long id);
}