package pl.kodolamacz.mvc.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kodolamacz.mvc.controllers.forms.AddUserForm;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.model.helpers.Users;
import pl.kodolamacz.spring.dao.repository.UserDao;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static pl.kodolamacz.mvc.controllers.UserController.BASE_URL;

/**
 * Created by acacko on 05.11.17
 */
@Controller
@RequestMapping(BASE_URL)
public class UserController {

    public static final String BASE_URL = "accounts";

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = GET)
    public String get(Model model) {
        model.addAttribute("users", userDao.findUsersFetchResevation());
        return BASE_URL;
    }

    @RequestMapping(value = "/add", method = GET)
    public String addNewUser(Model model) {
        model.addAttribute("userForm", new AddUserForm());
        return "addNewUser";
    }

    @RequestMapping(value = "/save", method = POST)
    public String saveNewUser(@Valid @ModelAttribute("userForm") AddUserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addNewUser";
        }
        userDao.save(new User(userForm.getEmail(), DigestUtils.md5Hex(userForm.getPassword())));
        return "redirect:/";
    }

    // zapytanie do naszego serwisu: accounts/ajax
    @RequestMapping(value = "/ajax", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<User> getUsers() {
        return userDao.findAll();
    }

    // 1. niedziałający XML
    @RequestMapping(value = "/ajax2", method = GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    List<User> getUsers2() {
        return userDao.findAll();
    }

    // 1. niedziałający XML
    @RequestMapping(value = "/ajax3", method = GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    User getUser() {
        return userDao.findOne(1L);
    }

    // 2. niedziałający XML - naprawiamy -> http://localhost:8080/kino/accounts/ajax4
    @RequestMapping(value = "/ajax4", method = GET, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    Users getUsers3() {
        return new Users(userDao.findAll());
    }

    /**
     * Przykład REST API: metoda POST, przesyłanie całego obiektu jako parametr
     */
    @RequestMapping(value = "/postUser", method = POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getUsers(@RequestBody User user) {
        userDao.save(user);
        return "PANIE! POST! GOTOWE!";
    }

    /**
     * Przykład użycia PUT. PUT NIC NIE ZWRACA
     */
    @RequestMapping(value = "/putUser", method = PUT)
    @ResponseBody
    public void putUser(@RequestBody User user) {
        userDao.save(user);
        System.out.println("ZAPISNO CZŁOWIEKU! PUT");
    }

    /**
     * Rozwiązanie problemu parsowania parametru ze znakiem specjalnym (@).
     * Wpis "email:.+" poprawia parsowaie tego znaku
     */
    @RequestMapping(value = "/byEmail/{email:.+}", method = RequestMethod.GET)
    public @ResponseBody
    User putUser(@PathVariable("email") String email) {
        return userDao.findByEmail(email);
    }

    /**
     * Przykład użycia DELETE. DELETE NIC NIE ZWRACA
     */
    @RequestMapping(value = "/delete/{email:.+}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("email") String email) {

        User user = userDao.findByEmail(email);
        userDao.delete(user);
        System.out.println("DELETE USER: " + user.getEmail());
    }


}
