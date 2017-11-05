package pl.kodolamacz.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.User;

/**
 * Created by acacko on 29.10.17
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email);


}
