package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Movie;

/**
 * Created by acacko on 29.10.17
 */
public interface MovieDao extends AbstractDao<Movie>{

    Movie findByTitle(String title);
}
