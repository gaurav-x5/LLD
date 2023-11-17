package org.example.model;

import lombok.Getter;
import lombok.NonNull;
import org.example.exception.SlotAlreadyOccupiedException;

import java.util.Date;

@Getter
public class Slot {
    private final String slotId;
    private final Size size;
    private final Locker locker;
    private LockerItem lockerItem;
    private Date allocationDate;

    public Slot(String slotId, Size size, Locker locker) {
        this.slotId = slotId;
        this.size = size;
        this.locker = locker;
        this.lockerItem = null;
    }

    public boolean isAvailable() {
        return this.lockerItem == null;
    }

    public void deallocateSlot() {
        this.lockerItem = null;
    }

    public void AllocateSlot(@NonNull final LockerItem lockerItem) {
        if(this.lockerItem != null) {
            throw new SlotAlreadyOccupiedException();
        }
        this.lockerItem = lockerItem;
        this.allocationDate = new Date();
    }
}
