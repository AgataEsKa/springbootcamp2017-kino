package pl.kodolamacz.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kodolamacz.spring.dao.model.Movie;
import pl.kodolamacz.spring.dao.repository.MovieDao;

import java.util.List;

import static pl.kodolamacz.mvc.controllers.MovieController.BASE_URL;

/**
 * Created by acacko on 19.11.17
 */
@Controller
@RequestMapping(value = BASE_URL)
public class MovieController {

    public static final String BASE_URL = "movies";

    @Autowired
    private MovieDao movieDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get(Model model) {
        // TODO: zrobić w końcu to w domu!!!
        return null;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  Movie getMovies() {
        return movieDao.findOne(1L);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  List<Movie> getMoviesAll() {
        return movieDao.findAll();
    }
}
