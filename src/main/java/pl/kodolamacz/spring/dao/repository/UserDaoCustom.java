package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.User;

/**
 * Created by acacko on 05.11.17
 */
public interface UserDaoCustom {

    User findByPaaasword(String password);

}
