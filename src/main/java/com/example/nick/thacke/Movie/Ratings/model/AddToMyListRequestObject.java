package com.example.nick.thacke.Movie.Ratings.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddToMyListRequestObject {

    @JsonProperty("movie")
    private Movie movie;

    @JsonProperty("username")
    private String username;

    public String getUsername() {
        return username;
    }
    public Movie getMovie() {
        return movie;
    }
    public AddToMyListRequestObject() {

    }
}
