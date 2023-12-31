package org.example.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.models.Direction;
import org.example.models.ElevatorCar;

import java.util.PriorityQueue;

@Getter
@Setter
@NoArgsConstructor
public class ElevatorController {
    PriorityQueue<Integer> upMinPQ;
    PriorityQueue<Integer> downMaxPQ;
    ElevatorCar elevatorCar;

    ElevatorController(ElevatorCar elevatorCar){

        this.elevatorCar = elevatorCar;
        upMinPQ = new PriorityQueue<>();
        downMaxPQ = new PriorityQueue<>((a,b) -> b-a);

    }
    public void submitExternalRequest(int floor, Direction direction){

        if(direction == Direction.DOWN) {
            downMaxPQ.offer(floor);
        } else {
            upMinPQ.offer(floor);
        }
    }

    public void submitInternalRequest(int floor){
        int currentFloor = elevatorCar.getCurrFloor();

        if (floor > currentFloor) {
            upMinPQ.add(floor);
        } else{
            downMaxPQ.add(floor);
        }

    }

    public void controlElevator(){
        while(true) {

            if(elevatorCar.getDirection() == Direction.UP){

                if(upMinPQ.size() > 0) {
                    int dest = upMinPQ.poll();
                    elevatorCar.move(dest, Direction.UP);
                }
                if(upMinPQ.size() == 0) {
                    elevatorCar.setDirection(Direction.DOWN);
                }
            } else {
                if(downMaxPQ.size() > 0) {
                    int dest = downMaxPQ.poll();
                    elevatorCar.move(dest, Direction.DOWN);
                }

                if(downMaxPQ.size() == 0) {
                    elevatorCar.setDirection(Direction.UP);
                }
            }
        }
    }

}
