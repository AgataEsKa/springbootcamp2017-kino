package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

/**
 * Created by acacko on 29.10.17
 */
@Repository
@Transactional
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        setClazz(User.class);
    }

    @Override
    public User findUser(String email) {
        return entityManager.createNamedQuery("User.byMail", clazz)
                .setParameter("email", email)
                .getSingleResult();
    }

}
