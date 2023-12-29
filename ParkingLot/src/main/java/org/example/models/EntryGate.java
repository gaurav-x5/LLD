package org.example.models;

import lombok.Getter;
import org.example.exception.ParkingFullException;
import org.example.repository.ParkingSpotRepo;
import org.example.repository.TicketRepo;

import java.time.Instant;
import java.util.Random;

@Getter
public class EntryGate {
    private int id;

    public EntryGate(int id) {
        this.id = id;
    }

    public ParkingTicket getTicket(VehicleEnum vehicle, String registrationId) {
        if(ParkingSpotRepo.vacantSpots.get(getSpot(vehicle)) > 0) {
            Random random = new Random(10);
            ParkingTicket parkingTicket = new ParkingTicket(registrationId, Instant.now(),
                    registrationId, vehicle);

            ParkingSpotRepo.vacantSpots.put(getSpot(vehicle),
                    ParkingSpotRepo.vacantSpots.get(getSpot(vehicle)) -1);
            TicketRepo.activeTicket.put(registrationId, parkingTicket);
            return parkingTicket;
        }
        else {
            System.out.println("Parking is full, Thank you!!");
            throw new ParkingFullException("Parking full for vehicle" + vehicle);
        }



    }

    private SpotEnum getSpot(VehicleEnum vehicleEnum) {
        if(vehicleEnum == VehicleEnum.CAR || vehicleEnum == VehicleEnum.VAN)
            return SpotEnum.COMPACT;
        else if(vehicleEnum == VehicleEnum.MOTORCYCLE) return SpotEnum.MOTORCYCLE;
        else if(vehicleEnum == VehicleEnum.TRUCK) return SpotEnum.LARGE;
        return SpotEnum.HANDICAPPED;
    }
}
