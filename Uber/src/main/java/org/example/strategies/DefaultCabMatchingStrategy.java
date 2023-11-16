package org.example.strategies;

import org.example.model.Cab;
import org.example.model.Location;
import org.example.model.Rider;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy{
    @Override
    public Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint) {
        if (candidateCabs.isEmpty()) {
            return null;
        }
        return candidateCabs.get(0);
    }
}
