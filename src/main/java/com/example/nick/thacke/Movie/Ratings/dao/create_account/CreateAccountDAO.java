package com.example.nick.thacke.Movie.Ratings.dao.create_account;

import com.example.nick.thacke.Movie.Ratings.model.Manager;
import com.example.nick.thacke.Movie.Ratings.model.User;

/**
 * This interface contains methods which enable a class which implements to have behavior of a Create Account Data Access Object.
 *
 * A Create Account Data Access Object, or CreateAccountDAO is an Object which allows operations for creating an account on it.
 */
public interface CreateAccountDAO {

    /**
     * A manager reference which is used to perform operations on the data.
     */
    Manager manager = Manager.getInstance();

    /**
     * Creates an account for the specified user.
     * @param user the User to create an account for
     * @return true if the account was successfully created, or false otherwise
     */
    boolean createAccount(User user);
}
