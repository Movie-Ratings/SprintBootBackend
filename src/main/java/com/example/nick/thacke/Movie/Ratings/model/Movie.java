package com.example.nick.thacke.Movie.Ratings.model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Movie implements Serializable {

    private UUID id;
    private String name;
    private Rating rating;

    private List<Comment> comments;

    public Movie(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

}
