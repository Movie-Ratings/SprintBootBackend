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


    /**
     * Injects movies into the database.
     * @return true if successful, false if an error occurred.
     */
    public boolean inject() {
        try {
            injectMovies();
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    private void injectMovies() throws IOException, JsonProcessingException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/popular?language=en-US&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4OTJjNzMzMTUzZWE4NjkxNGIzOWYyZjAzMzM5MjMyOCIsInN1YiI6IjYzY2Q4NWJmNmQ5N2U2MDA4YzI1OGY1YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.txs8GNV6HYgu_PwsLy-RAyum4THEajJ_4gf8l3sMwkw")
                .build();

        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());
        parseMovieJSON(response.body().string());

    }

    private void parseMovieJSON(String json) throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MovieData movieData = objectMapper.readValue(json, MovieData.class);

        List<Movie> movies = movieData.getResults();
        for (Movie movie : movies) {
            manager.addMovie(movie);
        }
    }

}
