package pl.kodolamacz.mvc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import pl.kodolamacz.spring.dao.model.Movie;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by acacko on 19.11.17
 */


public class RestTests {

    public RestTemplate restTemplate;

    @Before
    public void before() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void simpleRestRequest() {
        Movie movie = restTemplate.getForObject(
                "http://localhost:8080/kino/movies/get", Movie.class);
        assertThat(movie).isNotNull();
        assertThat(movie.getTitle()).isNotNull();
    }

    @Test
    public void simpleRestRequestForAll() {
        List<Movie> movie = (List<Movie>) restTemplate.getForObject(
                "http://localhost:8080/kino/movies/getAll", List.class);
        assertThat(movie).isNotEmpty();
    }

    @Test
    public void simpleRestRequestForAllVer2() {
        Movie[] movie = restTemplate.getForObject(
                "http://localhost:8080/kino/movies/getAll", Movie[].class);
        assertThat(movie).isNotEmpty();
    }




}
