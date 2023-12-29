package org.example.models;

import org.example.repository.ParkingSpotRepo;

import java.util.List;

public class ParkingLot {
    private int id;
    private String name;

    List<EntryGate> entryGates;
    List<ExitGate> exitGates;

    private static volatile ParkingLot parkingLot = null;

    public ParkingLot(int id, String name, List<EntryGate> entranceGate, List<ExitGate> exitGate) {
        this.id = id;
        this.name = name;
        this.entryGates = entranceGate;
        this.exitGates = exitGate;

        initParkingLotCapacity();
    }

    private void initParkingLotCapacity() {
        ParkingSpotRepo.vacantSpots.put(SpotEnum.COMPACT, 100);
        ParkingSpotRepo.vacantSpots.put(SpotEnum.LARGE, 100);
        ParkingSpotRepo.vacantSpots.put(SpotEnum.MOTORCYCLE, 100);
    }

    /**
     * this method return only instance of parking lot.
     * @return
     */
    public static ParkingLot getInstance() {
        if(parkingLot == null) {
            synchronized (ParkingLot.class) {
                if(parkingLot == null) {
                    parkingLot = ParkingLotFactory.getParkingLotInstance();
                }
            }
        }
        return parkingLot;
    }

    public ParkingTicket entry(VehicleEnum vehicleEnum, String registrationId ,int gateNumber) {
        System.out.println("Entry Success, Ticket provided for vehicle "+ vehicleEnum);
        return entryGates.get(gateNumber-1).getTicket(vehicleEnum, registrationId);
    }

    public boolean exit(String parkingTicketId, int gateNumber) {
        return exitGates.get(gateNumber-1).processParkingTicket(parkingTicketId);
    }

    public void displayAvailableParkingSlots() {
        //display ParkingSpotRepository

    }


}
