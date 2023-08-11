package com.example.nick.thacke.Movie.Ratings.dao;

import com.example.nick.thacke.Movie.Ratings.model.Manager;
import com.example.nick.thacke.Movie.Ratings.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDAO {

    Manager manager = Manager.getInstance();
    default void insertUser(User user) {
        manager.addUser(user);
    }
    default void insertUser(String username) {
        manager.addUser(username);
    }
    default User getUser(UUID id) {
        return manager.getUser(id);
    }
    default List<User> getUsers() {
        return manager.getUsers();
    }

}
