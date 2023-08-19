package com.example.nick.thacke.Movie.Ratings.util.data_injection;

import com.example.nick.thacke.Movie.Ratings.model.Manager;
import com.example.nick.thacke.Movie.Ratings.model.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public class MovieInjector {

    private Manager manager = Manager.getInstance();

    public enum Purpose {
        POPULAR, GENRE
    }

    /**
     * Injects the most popular movies into the database. Previously popular movies will be overwritten by this method.
     * @return
     */
    public boolean injectPopularMovies() {
        try {
            injectPopular();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Injects popular movies into the database by invoking an API request to The Movie Database. This will inject the first page results into our database.
     * @throws IOException
     */
    private void injectPopular() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4OTJjNzMzMTUzZWE4NjkxNGIzOWYyZjAzMzM5MjMyOCIsInN1YiI6IjYzY2Q4NWJmNmQ5N2U2MDA4YzI1OGY1YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.txs8GNV6HYgu_PwsLy-RAyum4THEajJ_4gf8l3sMwkw")
                .build();

        Response response = client.newCall(request).execute();
        parseMovieJSON(response.body().string(), Purpose.POPULAR);
    }

    /**
     * Parses the given json string as a List of movies. Depending upon the given reason, this method inserts the JSON into the manager.
     *
     * @param json
     * @throws JsonProcessingException
     * @throws IOException
     * @throws IllegalArgumentException when the purpose is not a valid purpose
     */
    private void parseMovieJSON(String json, Purpose purpose) throws JsonProcessingException, IOException, IllegalArgumentException {
        ObjectMapper objectMapper = new ObjectMapper();
        MovieData movieData = objectMapper.readValue(json, MovieData.class);

        List<Movie> movies = movieData.getResults();

        switch(purpose) {
            case POPULAR: {
                insertPopular(movies);
            }
            case GENRE: {
//                insertGenre(movies);
            }
        }
    }

    private void insertPopular(List<Movie> movies) {
        manager.
    }

}
