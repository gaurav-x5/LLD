package org.example.dao;

import org.example.model.Rider;

public interface RidersManager {
    Rider createRider(String riderId, String riderName);

    Rider getRider(String riderId);
}
