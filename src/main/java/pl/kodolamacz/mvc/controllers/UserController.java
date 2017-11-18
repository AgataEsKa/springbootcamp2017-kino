package pl.kodolamacz.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.kodolamacz.mvc.controllers.forms.AddUserForm;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
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
  public String saveNewUser(AddUserForm userForm) {

//    if(bindingResult.hasErrors()){
//      return "addNewUser";
//    }
    userDao.save(new User(userForm.getEmail(), userForm.getPassword()));
    return "redirect:/" + BASE_URL;
  }

//  accounts/ajax
  @RequestMapping(value = "/ajax", method = GET)
  public @ResponseBody List<User> getUsers() {
      return userDao.findAll();
  }

}
