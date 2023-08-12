package com.example.nick.thacke.Movie.Ratings.dao.create_account;
import com.example.nick.thacke.Movie.Ratings.model.Manager;
import com.example.nick.thacke.Movie.Ratings.model.User;

/**
 * This interface contains methods which enable a class which implements to have behavior of a Login Account Data Access Object.
 *
 * A Login Account Data Access Object, or LoginAccountDAO is an Object which allows operations for logging into an account.
 */
public interface LoginAccountDAO {
    /**
     * The Manager reference which is used to perfrom operations on data.
     */
    Manager manager = Manager.getInstance();

    /**
     * A status code indicating a successful login.
     */
    public static final int OK = 200;
    /**
     * A status code indicating an unsuccessful login.
     */
    public static final int UNSUCCESSFUL = 409;

    /**
     * @param user a User to login as
     * @return a status code indicating success or failure
     */
    default int login(User user) {
        User u = manager.getUser(user.getID());
        return u == null ? UNSUCCESSFUL : OK;
    }
}
