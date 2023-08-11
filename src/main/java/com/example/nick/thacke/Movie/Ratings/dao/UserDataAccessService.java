package com.example.nick.thacke.Movie.Ratings.dao;

import com.example.nick.thacke.Movie.Ratings.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("User")
public class UserDataAccessService implements UserDAO {

    @Override
    public void insertUser(User user) {
        manager.addUser(user);
    }
    @Override
    public List<User> getUsers() {
        return manager.getUsers();
    }
}
