package org.example.models;

import org.example.dispatchers.ExternalButtonDispatcher;
import org.example.dispatchers.OddEvenDispatcher;

public class Floor {
    int floorNumber;
    ExternalButton externalButton;


    public Floor(int floorNumber, ExternalButton externalButton){
        this.floorNumber = floorNumber;
        this.externalButton = externalButton;
    }
    public void pressButton(Direction direction) {
        externalButton.pressButton(floorNumber, direction);
    }

}
