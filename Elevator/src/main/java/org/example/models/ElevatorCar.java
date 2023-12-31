package org.example.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ElevatorCar {
    private int id;
    private Display display;
    private Direction direction;
    private Status status;
    private InternalButton button;
    private Door door;
    private int currFloor;

    public ElevatorCar(Display display, InternalButton internalButton, Door door) {
        this.display = display;
        this.button = internalButton;
        this.currFloor = 0;
        this.direction = Direction.UP;
        this.status = Status.IDLE;
        this.door = door;
    }

    public void showDisplay() {
        display.showDisplay();
    }

    public void setDisplay() {
        this.display.setDisplay(currFloor, direction);
    }


    public void pressButton(int destination) {
        button.pressButton(destination);
    }

    public boolean move(int floor, Direction direction) {
        int startFloor = currFloor;
        if(direction == Direction.UP) {
            for(int i = startFloor; i <= floor; i++) {
                this.currFloor = i;
                setDisplay();
                showDisplay();
            }

            return true;
        }

        if(direction == Direction.DOWN) {
            for(int i = startFloor; i >= floor; i--) {
                this.currFloor = currFloor;
                setDisplay();
                showDisplay();
            }

            return true;
        }

        return false;
    }

}
