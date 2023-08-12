package com.example.nick.thacke.Movie.Ratings.api.movie;

import com.example.nick.thacke.Movie.Ratings.model.Movie;
import com.example.nick.thacke.Movie.Ratings.service.create_account.LoginAccountService;
import com.example.nick.thacke.Movie.Ratings.service.movies.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie/")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }
    @PostMapping
    public ResponseEntity<String> injectMovies() {
        HttpStatus status = (movieService.injectMovies()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(null);
    }
}
