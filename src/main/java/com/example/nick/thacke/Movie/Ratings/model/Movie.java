package com.example.nick.thacke.Movie.Ratings.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Movie implements Serializable {

    /**
     * The ID of this Movie (in our database).
     */
    private UUID id;

    /**
     * The name of this movie.
     */
    private String name;
    /**
     * The Rating that users have given this movie.
     */
    private Rating rating;

    /**
     * The comments associated with this movie.
     */

    private List<Comment> comments;

    public Movie(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

}
