package org.example.model;

import lombok.NonNull;

public class Package implements LockerItem{
    private final String id;
    private final Size size;

    public Package(@NonNull final String id, @NonNull final Size size) {
        this.id = id;
        this.size = size;
    }
    @Override
    public Size getSize() {
        return size;
    }
}
