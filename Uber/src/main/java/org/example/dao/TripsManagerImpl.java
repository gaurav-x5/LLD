package org.example.dao;

import org.example.exceptions.NoCabsAvailableException;
import org.example.exceptions.TripNotFoundException;
import org.example.model.*;
import org.example.strategies.CabMatchingStrategy;
import org.example.strategies.PricingStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TripsManagerImpl implements TripsManager{

    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private Map<String, List<Trip>> trips = new HashMap<>();

    private CabsManager cabsManager;
    private RidersManager ridersManager;
    private CabMatchingStrategy cabMatchingStrategy;
    private PricingStrategy pricingStrategy;

    public TripsManagerImpl(
            CabsManager cabsManager,
            RidersManager ridersManager,
            CabMatchingStrategy cabMatchingStrategy,
            PricingStrategy pricingStrategy) {
        this.cabsManager = cabsManager;
        this.ridersManager = ridersManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public void createTrip(Rider rider, Location source, Location destination) {
        final List<Cab> closeByCabs = cabsManager.getCabs(source, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
        final List<Cab> closeByAvailableCabs = closeByCabs.stream()
                .filter(cab -> cab.getCurrentTrip() == null)
                .collect(Collectors.toList());
        final Cab selectedCab =
                cabMatchingStrategy.matchCabToRider(rider, closeByAvailableCabs, source, destination);
        if (selectedCab == null) {
            throw new NoCabsAvailableException();
        }

        final Double price = pricingStrategy.findPrice(source, destination);
        final Trip newTrip = new Trip(rider, selectedCab, price, source, destination);
        if (!trips.containsKey(rider.getId())) {
            trips.put(rider.getId(), new ArrayList<>());
        }
        trips.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);

    }

    @Override
    public List<Trip> tripHistory(Rider rider) {
        if(!trips.containsKey(rider.getId())) {
            throw new TripNotFoundException();
        }
        return trips.get(rider.getId());
    }

    @Override
    public void endTrip(Cab cab) {
        if(cab.getCurrentTrip() == null) {
            throw new TripNotFoundException();
        }

        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }
}
