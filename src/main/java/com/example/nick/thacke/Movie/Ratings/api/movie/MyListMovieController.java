package com.example.nick.thacke.Movie.Ratings.api.movie;

import com.example.nick.thacke.Movie.Ratings.model.AddToMyListRequestObject;
import com.example.nick.thacke.Movie.Ratings.model.Movie;
import com.example.nick.thacke.Movie.Ratings.service.movies.MyListMovieService;
import com.example.nick.thacke.Movie.Ratings.service.movies.PopularMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies/my_list")
public class MyListMovieController {

    private final MyListMovieService movieService;

    public MyListMovieController(MyListMovieService movieService) {
        this.movieService = movieService;
    }

    /**
     *
     * @return a List of the most popular Movies. This method will return an empty list if the injectMovies() function has not been invoked. That is, a POST request to /api/movie/popular has not bene made.
     */
    @GetMapping
    public List<Movie> getMovies(@RequestParam(name = "username") String username) {
        return movieService.getMyList(username);
    }

    /**
     * Posts
     * @return
     */
    @PostMapping
    public ResponseEntity<String> addToMyList(@RequestBody AddToMyListRequestObject body) {
        HttpStatus status = (movieService.insertIntoMyList(body.getMovie(), body.getUsername())) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(null);
    }
}
