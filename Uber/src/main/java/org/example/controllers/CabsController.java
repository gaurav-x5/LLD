package org.example.controllers;

import org.example.dao.CabsManager;
import org.example.dao.TripsManager;
import org.example.model.Cab;
import org.example.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/uber/api/v1/cabs")
public class CabsController {

    CabsManager cabsManager;
    TripsManager tripsManager;

    public CabsController(CabsManager cabsManager, TripsManager tripsManager) {
        this.cabsManager = cabsManager;
        this.tripsManager = tripsManager;
    }
    @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
    public ResponseEntity registerCab(final String cabId, final String driverName) {
        Cab cab = cabsManager.registerCab(cabId, driverName);
        return ResponseEntity.ok(cab);
    }

    @RequestMapping(value = "/update/cab/location", method = RequestMethod.PUT)
    public ResponseEntity updateCabLocation(
            final String cabId, final Double newX, final Double newY) {
        cabsManager.updateCabLocation(cabId, new Location(newX, newY));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/update/cab/availability", method = RequestMethod.PUT)
    public ResponseEntity updateCabAvailability(final String cabId, final Boolean newAvailability) {
        cabsManager.updateCabAvailability(cabId, newAvailability);
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/cab/end/trip", method = RequestMethod.PUT)
    public ResponseEntity endTrip(final String cabId) {
        tripsManager.endTrip(cabsManager.getCab(cabId));
        return ResponseEntity.ok("");
    }

}
