package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by acacko on 29.10.17
 */
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    @Override
    public User findUser(String email) {
        return entityMap.values()
                .stream()
                .filter(usr -> usr.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addEntity(User entity) {

    }
}
