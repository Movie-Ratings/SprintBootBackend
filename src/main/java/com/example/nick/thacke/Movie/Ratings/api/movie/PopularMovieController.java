package com.example.nick.thacke.Movie.Ratings.api.movie;

import com.example.nick.thacke.Movie.Ratings.model.Movie;
import com.example.nick.thacke.Movie.Ratings.service.movies.MovieService;
import com.example.nick.thacke.Movie.Ratings.service.movies.PopularMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie/popular/")
public class PopularMovieController {

    private final PopularMovieService movieService;

    public PopularMovieController(PopularMovieService movieService) {
        this.movieService = movieService;
    }

    /**
     *
     * @return a List of the most popular Movies. This method will return an empty list if the injectMovies() function has not been invoked. That is, a POST request to /api/movie/popular has not bene made.
     */
    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getPopularMovies();
    }

    /**
     * Posts the most popular movies to our internal database. The data is obtained by accessing The Movie Database's API for most popular movies.
     *
     * This method should be invoked on each refresh of the popular movies -- this ensures that popularity is up to date.
     * @return a ResponseEntity indicating the server response. More formerly, ResponsEntity.status == 200 if successful, otherwise an error occurred (somewhere along the process).
     */
    @PostMapping
    public ResponseEntity<String> injectMovies() {
        HttpStatus status = (movieService.injectPopularMovies()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(null);
    }
}
