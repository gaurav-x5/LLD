package org.example.dao;

import org.example.model.Cab;
import org.example.model.Location;
import org.example.model.Rider;
import org.example.model.Trip;

import java.util.List;

public interface TripsManager {
    public void createTrip(Rider rider, Location source, Location destination);

    List<Trip> tripHistory(Rider rider);
    void endTrip(Cab cab);
}
