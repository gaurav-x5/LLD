package org.example.models;

import org.example.service.FixedRate;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotFactory {


    public static ParkingLot getParkingLotInstance() {
        List<EntryGate> entryGates = new ArrayList<>();
        EntryGate entryGate = new EntryGate(1);
        EntryGate entryGate1 = new EntryGate(2);
        entryGates.add(entryGate);
        entryGates.add(entryGate1);

        List<ExitGate> exitGates = new ArrayList<>();
        ExitGate exitGate = new ExitGate(1, new FixedRate());
        ExitGate exitGate1 = new ExitGate(2, new FixedRate());
        exitGates.add(exitGate);
        exitGates.add(exitGate1);

        return new ParkingLot(12, "Pheonix",
                entryGates, exitGates);
    }
}
