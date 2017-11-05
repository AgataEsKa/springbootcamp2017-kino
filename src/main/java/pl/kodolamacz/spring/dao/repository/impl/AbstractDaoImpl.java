package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kodolamacz.spring.dao.model.AbstractEntity;
import pl.kodolamacz.spring.dao.repository.AbstractDao;
import pl.kodolamacz.spring.dao.tools.Generator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by acacko on 29.10.17
 */
public abstract class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> clazz;

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    Map<Long, T> entityMap = new HashMap<>();

    @Autowired
    private Generator generator;

    public T findById(Long id) {
        return entityMap.get(id);
//        return entityManager.find(clazz, id);
    }

    public void save(T entity) {
        entity.setId(generator.getUniqueId());
        entityMap.put(entity.getId(), entity);
    }


    public List<T> findAll() {
        // zapytanie o wiele
        return entityManager
                .createQuery("from " + clazz.getName(), clazz)
                .getResultList();
    }
}
