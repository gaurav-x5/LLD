package org.example.dao;

import org.example.exceptions.RiderAlreadyExistsException;
import org.example.exceptions.RiderNotFoundException;
import org.example.model.Rider;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RidersManagerImpl implements RidersManager{

    Map<String, Rider> riderMap = new HashMap<>();

    @Override
    public Rider createRider(String riderId, String riderName) {
        if(riderMap.containsKey(riderId)) {
            throw new RiderAlreadyExistsException();
        }
        Rider rider = new Rider(riderId, riderName);
        riderMap.put(riderId, rider);
        return  rider;
    }

    @Override
    public Rider getRider(String riderId) {
        if(!riderMap.containsKey(riderId)) {
            throw new RiderNotFoundException();
        }
        return riderMap.get(riderId);
    }
}
