package org.example.models;

import org.example.dispatchers.InternalButtonDispatcher;

public class InternalButton {
    InternalButtonDispatcher internalButtonDispatcher;

    public InternalButton(InternalButtonDispatcher internalButtonDispatcher) {
        this.internalButtonDispatcher = internalButtonDispatcher;
    }

    public void pressButton(int floor) {

    }
}
