package org.example;

import org.example.controller.ElevatorController;
import org.example.dispatchers.InternalButtonDispatcher;
import org.example.models.ElevatorCar;
import org.example.models.InternalButton;

public class Main {
    public static void main(String[] args) {
        InternalButtonDispatcher internalButtonDispatcher = new InternalButtonDispatcher();
        ElevatorController elevatorController = new ElevatorController();

        InternalButton internalButton = new InternalButton(new InternalButtonDispatcher());
        ElevatorCar elevatorCar = ElevatorCar.builder().id(1).build();
    }
}