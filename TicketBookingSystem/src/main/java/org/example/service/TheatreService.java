package org.example.service;

import org.example.model.Screen;
import org.example.model.Seat;
import org.example.model.Theatre;

public interface TheatreService {
    Theatre createTheatre(String theatreName);

    Theatre getTheatre(String theatreId);

    Screen createScreenInTheatre(String screenName, Theatre theatre);

    Screen getScreen(String screenId);

    Seat createSeatInTheatre(Integer rowNo, Integer seatNo, Screen screen);
}
