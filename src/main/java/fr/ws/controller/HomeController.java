package fr.ws.controller;

import fr.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("name", "Hmiza & Mimi");
        model.addAttribute("users", userService.getUsers());
        return "home";
    }
}
