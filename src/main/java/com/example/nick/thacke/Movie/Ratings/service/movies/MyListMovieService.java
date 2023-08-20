package com.example.nick.thacke.Movie.Ratings.service.movies;

import com.example.nick.thacke.Movie.Ratings.dao.movie.MovieDAO;
import com.example.nick.thacke.Movie.Ratings.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyListMovieService implements MovieDAO {

    /**
     *
     * @param username a username to obtain a list of movies for
     * @return a List of Movies which this user has added to their "MyList" section.
     */
    public List<Movie> getMyList(String username) {
        return manager.getMylist(username);
    }

    /**
     * Inserts the given movie into the "MyList" section of the app.
     *
     * @param movie a movie to insert
     * @param username a username whose list this movie will be inserted into
     * @return true if successfully inserted, or false otherwise (the movie already is in the list)
     */
    public boolean insertIntoMyList(Movie movie, String username) {
        return manager.addToMyList(username, movie);
    }
}
