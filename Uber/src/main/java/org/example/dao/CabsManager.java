package org.example.dao;

import lombok.NonNull;
import org.example.model.Cab;
import org.example.model.Location;

import java.util.List;

public interface CabsManager {

    Cab registerCab(String cabId, String driverName);
    void updateCabLocation(String cabId, Location location);
    void updateCabAvailability(String cabId, boolean newAvailability);
    Cab getCab(String cabId);

    List<Cab> getCabs(@NonNull final Location location, @NonNull final Double distance);
}
