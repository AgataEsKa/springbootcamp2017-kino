package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kodolamacz.spring.dao.model.Entity;
import pl.kodolamacz.spring.dao.repository.AbstractDao;
import pl.kodolamacz.spring.dao.tools.Generator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by acacko on 29.10.17
 */
public abstract class AbstractDaoImpl<T extends Entity> implements AbstractDao<T> {

    Map<Long, T> entityMap = new HashMap<>();

    @Autowired
    Generator generator;

    public T findById(Long id) {
        return entityMap.get(id);
    }

    public void addEntity(T entity) {
        entityMap.put(generator.getUniqueId(), entity);
    }
}