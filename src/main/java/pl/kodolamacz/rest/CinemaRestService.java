package pl.kodolamacz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static pl.kodolamacz.rest.CinemaRestService.BASE_URL;

/**
 * Prawilnie powinno być tak:
 * Adnotacja: @RestController powoduje że wszystko jest jako @RequestBody
 */
@RestController
@RequestMapping(value = BASE_URL)
public class CinemaRestService {

    public static final String BASE_URL = "api";

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/postUser", method = POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getUsers(@RequestBody User user) {
        userDao.save(user);
        return "PANIE! POST! GOTOWE!";
    }

}
