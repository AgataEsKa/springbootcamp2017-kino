package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.User;

import java.util.List;

/**
 * Created by acacko on 29.10.17
 */
public interface UserDao extends AbstractDao<User> {

    User findUser(String email);

    List<User> findAll();

}
