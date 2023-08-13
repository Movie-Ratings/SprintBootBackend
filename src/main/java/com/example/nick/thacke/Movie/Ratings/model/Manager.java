package com.example.nick.thacke.Movie.Ratings.model;

import com.example.nick.thacke.Movie.Ratings.data.Serializer;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * A manager which contains information regarding the rest of the backend. This class guarantees an implementation of the singleton design pattern, wherein Manager.getInstance() will always return the same instance of Manager for any running application.
 *
 */
public class Manager implements Serializable {

    /**
     * The singleton instance of Manager.
     */
    private static Manager shared;

    /**
     * The movies stored in the application.
     */
    private HashMap<Integer, Movie> movies;

    /**
     * The users stored in the application.
     */
    private HashMap<String, User> users;

    /**
     * A private constructor which ensures that no external classes may instantiate their own instance of Manager.
     */
    private Manager() {
        try {
            shared = Serializer.load();
        }
        catch(Exception e) {
            this.movies = new HashMap<>();
            this.users = new HashMap<>();
            shared = this;
        }
    }

    /**
     *
     * @return an instance of Manager. The Manager Object conforms to the Singleton Design Pattern, wherein only one instance of Manager may be in existence.
     * This method ensures that any invocations of it returns the same instance of Manager, so long as each invocation is in the same application.
     *
     * That is to say that different applications may have a different instance of Manager. That is in the sense that in one specific application, Object X gets returned. Once the application has finished, Object X technically no longer exists -- the internal representation of it is stored on disk, but the reference to that object no longer exists.
     * Applications that then load the data and create their own instance are now a separate Object, in the sense that the Object Reference is now different from the previous application, albeit, their internal fields may be the same -- they are not actually the same object.
     *
     */
    public static Manager getInstance() {
        if(shared == null) {
            new Manager();
        }
        return shared;
    }

    /**
     * Adds the specific user instance to the model.
     * @param user
     */
    public boolean addUser(User user) {
        User value = users.putIfAbsent(user.getUsername(), user);
        save();
        return value == null ? true : false;
    }

    /**
     * Saves the current instance of Manager to the disk. Future applications will load the saved instance.
     */
    public void save() {
        try {
            Serializer.save(shared);
        }
        catch(IOException e) {
            System.out.println("An error occurred while trying to save to disk.");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param username the username of a user to add to the database.
     * @return true if the user was successfully added, or false otherwise
     */
    public boolean addUser(String username) {
        UUID id = UUID.randomUUID();
        User user = new User(id, username);
        return addUser(user);
    }

    /**
     * @param username username of a user
     * @return the User associated with the given ID
     */
    public User getUser(String username) {
        return users.get(username);
    }

    /**
     * @return a List of all users in the model.
     */
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        for(String key : users.keySet()) {
            User user = users.get(key);
            list.add(user);
        }
        return list;
    }

    /**
     * Adds the given Movie to the database.
     * @param movie
     */
    public void addMovie(Movie movie) {
        movies.put(movie.getID(), movie);
        save();
    }

    /**
     *
     * @return a List of Movies in the database.
     */
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        for(Integer key : this.movies.keySet()) {
            Movie movie = this.movies.get(key);
            movies.add(movie);
        }
        return movies;
    }

    public String toString() {
        return "Users : " + users + " Movies : " + movies;
    }
}
