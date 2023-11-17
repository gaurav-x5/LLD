package org.example.service;

import org.example.model.Movie;
import org.example.model.Screen;
import org.example.model.Show;

import java.util.Date;

public interface ShowService {
    public Show getShow(String showId);

    Show createShow(Movie movie, Screen screen, Date startTime, Integer durationInSeconds);
}
