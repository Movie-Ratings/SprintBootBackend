package model;

import data.Serializer;

import java.io.Serial;
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
    private HashMap<UUID, Movie> movies;

    /**
     * The users stored in the application.
     */
    private HashMap<UUID, User> users;

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
            shared = new Manager();
        }
        return shared;
    }

    /**
     * Adds the specific user instance to the model.
     * @param user
     */
    public void addUser(User user) {
        users.put(user.getID(), user);
    }

    /**
     * Creates a User object with the given username and inserts them into the model. Usernames are allowed to be repeated.
     * @param username
     */
    public void addUser(String username) {
        UUID id = UUID.randomUUID();
        User user = new User(id, username);
        users.put(id, user);
    }

    /**
     * @param id an ID of a user
     * @return the User associated with the given ID
     */
    public User getUser(UUID id) {
        return users.get(id);
    }

    /**
     * @return a List of all users in the model.
     */
    public List<User> getUsers() {
        List<User> list = new ArrayList<>();
        for(UUID key : users.keySet()) {
            User user = users.get(key);
            list.add(user);
        }
        return list;
    }
}
