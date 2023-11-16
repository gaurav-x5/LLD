package org.example.dao;

import lombok.NonNull;
import org.example.exceptions.CabAlreadyExistsException;
import org.example.exceptions.CabNotFoundException;
import org.example.model.Cab;
import org.example.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CabsManagerImpl implements CabsManager{

    Map<String, Cab> cabs = new HashMap<>();
    @Override
    public Cab registerCab(String cabId, String driverName) {
        if(cabs.containsKey(cabId)) {
            throw new CabAlreadyExistsException();
        }
        Cab cab = new Cab(cabId, driverName);
        cabs.put(cabId, cab);
        return cab;
    };

    @Override
    public void updateCabLocation(String cabId, Location location) {
        if(!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        Cab cab = cabs.get(cabId);
        cab.setCurrentLocation(location);
    }

    @Override
    public void updateCabAvailability(String cabId, boolean newAvailability) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        cabs.get(cabId).setIsAvailable(newAvailability);
    }

    @Override
    public Cab getCab(String cabId) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotFoundException();
        }
        return cabs.get(cabId);
    }

    @Override
    public List<Cab> getCabs(@NonNull Location fromPoint, @NonNull Double distance) {
        List<Cab> result = new ArrayList<>();
        for(Cab cab : cabs.values()) {
            if(cab.getIsAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance)
                result.add(cab);
        }

        return result;
    }


}
