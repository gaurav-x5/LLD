package org.example.model;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private final String lockerId;
    private List<Slot> slots;

    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.slots = new ArrayList<>();
    }

    public void addSlot(@NonNull final Slot newSlot) {
        this.slots.add(newSlot);
    }

    public List<Slot> getAvailableSlots() {
        final List<Slot> result = new ArrayList<>();
        for (Slot slot : this.slots) {
            if (slot.isAvailable()) {
                result.add(slot);
            }
        }
        return result;
    }
}
