package pl.kodolamacz.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kodolamacz.spring.dao.model.Movie;

/**
 * Created by acacko on 29.10.17
 */
public interface MovieDao extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);
}
