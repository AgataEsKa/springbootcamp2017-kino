package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Entity;

/**
 * Created by acacko on 29.10.17
 */
public interface AbstractDao<T extends Entity> {

    T findById(Long id);

    void save(T entity);

}
