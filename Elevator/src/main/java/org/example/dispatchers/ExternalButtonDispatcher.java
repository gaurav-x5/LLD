package org.example.dispatchers;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.controller.ElevatorController;
import org.example.models.Direction;

import java.util.HashMap;
import java.util.List;

@Setter
public abstract class ExternalButtonDispatcher {
    public abstract void submit(int floor, Direction direction);
}
