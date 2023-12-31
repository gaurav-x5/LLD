package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Door {
    private int id;
    private boolean isOpen;

    public void openDoor() {
        System.out.println("opening the elevator door ");
        isOpen = true;
    }

    public void closeDoor() {
        System.out.println("closing the Elevator door ");
        isOpen = false;
    }


}
