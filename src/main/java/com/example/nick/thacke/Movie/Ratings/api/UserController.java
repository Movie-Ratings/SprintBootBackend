package com.example.nick.thacke.Movie.Ratings.api;

import com.example.nick.thacke.Movie.Ratings.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.example.nick.thacke.Movie.Ratings.service.UserService;

import java.util.List;

@RequestMapping("/api/users")
@RestController
@Component
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public void insertUser(@RequestBody User user) {
        User u = new User(user.getUsername());
        System.out.println("Inserting user " + u);
        userService.insertUser(u);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }




}
