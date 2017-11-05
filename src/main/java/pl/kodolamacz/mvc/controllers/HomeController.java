package pl.kodolamacz.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by acacko on 05.11.17
 */

@Controller
public class HomeController {

    @RequestMapping(name = "/", method = GET)
    public String get() {
        return "home";
    }
}
