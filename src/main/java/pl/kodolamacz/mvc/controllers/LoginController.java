package pl.kodolamacz.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by acacko on 19.11.17
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String get() {
        return "login";
    }

    @RequestMapping(value = "login-error", method = RequestMethod.GET)
    public String wrongPassword(Model model) {
        model.addAttribute("wrong", true);
        return "login";
    }

}
