package org.example.service;

import org.example.model.Movie;

public interface MovieService {
    Movie createMovie(String movieName);

    Movie getMovie(String movieId);
}
