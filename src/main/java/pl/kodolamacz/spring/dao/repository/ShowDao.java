package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Show;

import java.util.List;

/**
 * Created by acacko on 29.10.17
 */
public interface ShowDao extends AbstractDao<Show> {

    List<Show> findByMovieTitle(String movieTitle);

}
