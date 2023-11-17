package org.example.service;

import org.example.exceptions.NotFoundException;
import org.example.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieServiceImpl implements MovieService{

    Map<String, Movie> movieMap;

    public MovieServiceImpl() {
        this.movieMap = new HashMap<>();
    }

    @Override
    public Movie createMovie(String movieName) {
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId, movieName);
        movieMap.put(movieId, movie);
        return movie;
    }

    @Override
    public Movie getMovie(String movieId) {
        if (!movieMap.containsKey(movieId)) {
            throw new NotFoundException();
        }

        return movieMap.get(movieId);
    }
}
