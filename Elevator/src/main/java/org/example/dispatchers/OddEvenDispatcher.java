package org.example.dispatchers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controller.ElevatorController;
import org.example.models.Direction;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OddEvenDispatcher extends ExternalButtonDispatcher{

    private List<ElevatorController> elevatorControllerList;
    @Override
    public void submit(int floor, Direction direction) {

        //for simplicity, i am following even odd,
        for(ElevatorController elevatorController : elevatorControllerList) {

            int elevatorID = elevatorController.getElevatorCar().getId();
            if (elevatorID%2==1 && floor%2==1){
                elevatorController.submitExternalRequest(floor,direction);
            } else if(elevatorID%2==0 && floor%2==0){
                elevatorController.submitExternalRequest(floor,direction);

            }
        }

    }
}
