package pl.kodolamacz.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.Show;

import java.util.Date;
import java.util.List;

/**
 * Created by acacko on 29.10.17
 */
@Repository
public interface ShowDao extends JpaRepository<Show, Long> {

    List<Show> findByMovieTitle(String movieTitle);

    List<Show> findByDateBetween(Date start, Date stop);

}
