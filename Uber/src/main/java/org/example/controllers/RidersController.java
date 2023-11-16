package org.example.controllers;

import org.example.dao.RidersManager;
import org.example.dao.TripsManager;
import org.example.model.Location;
import org.example.model.Rider;
import org.example.model.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/uber/api/v1/rider")
public class RidersController {

    private RidersManager ridersManager;
    private TripsManager tripsManager;

    public RidersController(RidersManager ridersManager, TripsManager tripsManager) {
        this.ridersManager = ridersManager;
        this.tripsManager = tripsManager;
    }

    @RequestMapping(value = "/register/rider",method = RequestMethod.POST)
    public ResponseEntity registerRider(final String riderId, final String riderName) {
        Rider rider = ridersManager.createRider(riderId, riderName);
        return ResponseEntity.ok(rider);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity book(
            final String riderId,
            final Double sourceX,
            final Double sourceY,
            final Double destX,
            final Double destY) {

        tripsManager.createTrip(ridersManager.getRider(riderId),
                new Location(sourceX, sourceY), new Location(destX, destY));

        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseEntity fetchHistory(final String riderId) {
        List<Trip> trips = tripsManager.tripHistory(ridersManager.getRider(riderId));
        return ResponseEntity.ok(trips);
    }

}
