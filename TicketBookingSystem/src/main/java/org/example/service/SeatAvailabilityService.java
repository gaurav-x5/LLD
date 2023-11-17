package org.example.service;

import org.example.model.Seat;
import org.example.model.Show;

import java.util.List;

public interface SeatAvailabilityService {
    List<Seat> getAvailableSeats(Show show);
}
