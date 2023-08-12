package com.example.nick.thacke.Movie.Ratings.util.data_injection;

import com.example.nick.thacke.Movie.Ratings.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieData {
    public int page;
    public List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }
    public int getPage() {
        return page;
    }
    public MovieData(int page, List<Movie> results) {
        this.page = page;
        this.results = results;
    }
    public MovieData() {

    }
}
