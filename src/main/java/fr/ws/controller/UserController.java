package fr.ws.controller;

import fr.ws.bean.User;
import fr.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() throws UnknownHostException {
        return userService.getUsers();
    }

    @PostMapping(value = "/users/remove/{id}")
    public List<User> removeUser(@PathVariable String id) {
        return userService.removeUser(id);
    }

    @GetMapping(value = "/users/removeAll")
    public boolean removeAll() {
        return userService.removeAll();
    }

    @PostMapping(value = "/users/add/{name}/{age}")
    public List<User> addUSer( @PathVariable String name, @PathVariable String age) {
        return userService.addUser(name, age);
    }
}
