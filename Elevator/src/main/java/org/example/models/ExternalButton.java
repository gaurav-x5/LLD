package org.example.models;

import org.example.dispatchers.ExternalButtonDispatcher;

public class ExternalButton {
    ExternalButtonDispatcher externalButtonDispatcher;

    public ExternalButton(ExternalButtonDispatcher externalButtonDispatcher) {
        this.externalButtonDispatcher = externalButtonDispatcher;
    }

    public void pressButton(int floor, Direction direction) {
        externalButtonDispatcher.submit(floor, direction);
    }
}
