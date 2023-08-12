package com.example.nick.thacke.Movie.Ratings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {

    /**
     * The ID of this Movie (in our database).
     */
    @JsonIgnore
    private UUID id;

    /**
     * The name of this movie.
     */
    private String title;
    /**
     * The Rating that users have given this movie.
     */
    private Rating rating;

    /**
     * The comments associated with this movie.
     */

    private List<Comment> comments;
    /**
     * The director of the movie.
     */
    private String director;

    /**
     * The description / overview of this movie.
     */
    private String overview;

    /**
     * @return the title of this movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the director of this movie
     */
    public String getDirector() {
        return director;
    }

    /**
     * @return an overview of this movie
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @return the ID of this movie
     */
    public UUID getID() {
        return id;
    }

    public Movie(String title, String director, String overview) {
        id = UUID.randomUUID();
        this.title = title;
        this.director = director;
        this.overview = overview;
    }

    public Movie() {
        id = UUID.randomUUID();
    }

}
