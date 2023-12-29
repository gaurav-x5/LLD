package org.example;

import org.example.models.ParkingLot;
import org.example.models.ParkingTicket;
import org.example.models.VehicleEnum;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingTicket parkingTicket = parkingLot.entry(VehicleEnum.CAR, "KA7368",1);
        Thread.sleep(1000);
        parkingLot.exit(parkingTicket.getId(), 1);
    }
}