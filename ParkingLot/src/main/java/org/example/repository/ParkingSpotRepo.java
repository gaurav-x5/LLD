package org.example.repository;

import org.example.models.SpotEnum;

import java.util.HashMap;

public class ParkingSpotRepo {
    public static HashMap<SpotEnum, Integer> vacantSpots = new HashMap<>();
    public static HashMap<SpotEnum, Integer> occupiedSpots = new HashMap<>();

    private ParkingSpotRepo() {

    }
}
