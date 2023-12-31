package org.example.dispatchers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controller.ElevatorController;

import java.util.HashMap;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class InternalButtonDispatcher {
    private List<ElevatorController> controllers;


    public void submit(int elevatorId, int floor) {
        controllers.get(elevatorId -1).submitInternalRequest(floor);
    }


}
