package com.example.nick.thacke.Movie.Ratings.service;

import com.example.nick.thacke.Movie.Ratings.dao.UserDAO;
import com.example.nick.thacke.Movie.Ratings.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("User") UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }


}
