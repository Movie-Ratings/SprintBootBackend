package com.example.nick.thacke.Movie.Ratings.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;
import java.util.*;

public class User implements Serializable {

    /**
     * The ID associated with this user.
     */
    private UUID id;

    /**
     * The username of this user.
     */
    private String username;

    /**
     * The email of this user
     */
    private String email;

    /**
     * This constructor creates a new User object and generates a random ID for the given user. This constructor should be used only when creating a fresh User.
     * @param username
     */

    /**
     * The comments made by this user.
     */
    private List<Comment> comments;

    public User(@JsonProperty String username) {
        this.id = UUID.randomUUID();
        this.username = username;
    }

    /**
     * This constructor creates a new User object from a given ID and username. This constructor should be invoked any time other than User creation. In other words, loading information should use this constructor.
     * Otherwise, the ID will be randomly generated, and the previous user who had the given username would have their information "lost", in the sense that it is not accessible. However, it would still exist, albeit, under the appropriate ID (the ID created on user creation).
     * @param id
     * @param username
     */
    public User(@JsonProperty UUID id,
                @JsonProperty String username) {
        this.id = id;
        this.username = username;
    }

    /**
     * @return the ID associated with this user.
     */
    public UUID getID() {
        return id;
    }

    /**
     * @return the username associated with this user.
     */
    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "(ID : " + id + " | Username : " + username + ")";
    }
}
