package com.example.nick.thacke.Movie.Ratings.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {

    /**
     * The ID of this Movie
     */
    private int id;

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
     * The description / overview of this movie.
     */
    private String overview;

    /**
     * The path to the poster of this movie, with respect to The Movie Database.
     *
     * To access the poster, invoke the url :
     *  https://image.tmdb.org/t/p/w500/{poster_path}
     */
    @JsonProperty("poster_path")
    private String poster_path;

    /**
     * The path to the backdrop of this movie, with respect to The Movie Database.
     *
     * To access the backdrop, invoke the url :
     *  https://image.tmdb.org/t/p/w1280/{backdrop_path}
     */
    @JsonProperty("backdrop_path")
    private String backdrop_path;

    @JsonProperty("release_date")
    private String release_date;

    /**
     * @return the title of this movie
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return an overview of this movie
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @return a poster path of this movie which TMDB stores.
     */
    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    /**
     *
     * @return the ID of this movie
     */
    public int getID() {
        return id;
    }

    public Movie(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }

    public Movie() {
    }

}
