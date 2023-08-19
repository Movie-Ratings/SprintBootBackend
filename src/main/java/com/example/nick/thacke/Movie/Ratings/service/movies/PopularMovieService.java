package com.example.nick.thacke.Movie.Ratings.service.movies;

import com.example.nick.thacke.Movie.Ratings.dao.movie.MovieDAO;
import com.example.nick.thacke.Movie.Ratings.model.Movie;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PopularMovieService implements MovieDAO {

    public List<Movie> getPopularMovies() {
        return manager.getPopularMovies();
    }

    public boolean injectPopularMovies() {
        return manager.injectPopularMovies();
    }
}
