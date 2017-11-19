package pl.kodolamacz.mvc;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import pl.kodolamacz.spring.dao.model.Movie;
import pl.kodolamacz.spring.dao.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by acacko on 19.11.17
 */


/**
 * TESTY WYKONYWAĆ PRZY WŁĄCZONEJ APLIKACJI.
 * PAMIĘTAĆ O EWENTUALNYM WYEDYTOWANIU ŚCIEŻKI w BASE_URL
 */

@Ignore
public class RestTests {

    public RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/kino";

    @Before
    public void before() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void simpleRestRequest() {
        Movie movie = restTemplate.getForObject(
                BASE_URL + "/movies/get", Movie.class);
        assertThat(movie).isNotNull();
        assertThat(movie.getTitle()).isNotNull();
    }

    @Test
    public void simpleRestRequestForAll() {
        List<Movie> movie = (List<Movie>) restTemplate.getForObject(
                BASE_URL + "/movies/getAll", List.class);
        assertThat(movie).isNotEmpty();
    }

    @Test
    public void simpleRestRequestForAllVer2() {
        Movie[] movie = restTemplate.getForObject(
                BASE_URL + "/movies/getAll", Movie[].class);
        assertThat(movie).isNotEmpty();
    }

    @Test
    public void simpleRestPostMethod() {
        User user = new User("aaa@sdf.pl", "paass");
        String result = restTemplate.postForObject(
                BASE_URL + "/accounts/postUser",
                user, String.class);
        System.out.println(result);
    }

    @Test
    public void simpleRestPutMethod() {
        String email = "aaa@sdf.pl";
        User user = new User(email, "paass");
        restTemplate.put(BASE_URL + "/accounts/putUser", user);
        User userReturn = restTemplate.getForObject("http://localhost:8080/kino/accounts/byEmail/" + email, User.class);
        System.out.println(userReturn);

    }

    @Test
    public void simpleRestDeleteMethod() {
        // dodaję użytkownika
        String email = "aaa2@sdf.pl";   // %40
        User user = new User(email, "paass");
        String result = restTemplate.postForObject(
                BASE_URL + "/accounts/postUser",
                user, String.class);

        restTemplate.delete(BASE_URL + "/accounts/delete/" + email);

    }

}
