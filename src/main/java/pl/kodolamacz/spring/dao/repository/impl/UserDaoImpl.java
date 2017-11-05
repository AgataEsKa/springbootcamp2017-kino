package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDaoCustom;

/**
 * Created by acacko on 05.11.17
 */
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDaoCustom {

    public UserDaoImpl() {
        setClazz(User.class);
    }

    @Override
    public User findByPaaasword(String password) {
        return entityManager.createQuery("from " + clazz.getName() + " where password = :password", clazz)
                .setParameter("password", password)
                .getSingleResult();
    }
}
