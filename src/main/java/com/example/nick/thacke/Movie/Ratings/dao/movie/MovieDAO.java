package com.example.nick.thacke.Movie.Ratings.dao.movie;

import com.example.nick.thacke.Movie.Ratings.model.Manager;
import com.example.nick.thacke.Movie.Ratings.model.Movie;
import com.example.nick.thacke.Movie.Ratings.util.data_injection.MovieInjector;

import java.util.List;

public interface MovieDAO {

    Manager manager = Manager.getInstance();
    default List<Movie> getMovies() {
        return manager.getMovies();
    }
    default boolean injectMovies() {
        MovieInjector injector = new MovieInjector();
        return injector.inject();
    }
}
