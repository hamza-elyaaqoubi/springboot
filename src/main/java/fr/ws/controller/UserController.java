package fr.ws.controller;

import fr.ws.bean.User;
import fr.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/users/add/{id}/{name}/{age}")
    public List<User> addUSer(@PathVariable String id, @PathVariable String name, @PathVariable String age) {
        return userService.addUser(id, name, age);
    }

    @PostMapping(value = "/users/add")
    public List<User> addUSer2(@RequestBody User user) {
        return userService.addUser(user);
    }
}
