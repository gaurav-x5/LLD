package org.example.service;

import org.example.model.Locker;
import org.example.model.LockerItem;
import org.example.model.Size;
import org.example.model.Slot;

import java.util.List;

public interface LockerService {
    Locker createLocker(String lockerId);

    Slot createSlot(String lockerId, Size slotSize);

    List<Slot> getAllAvailableSlots();

    void deallocateSlot(Slot slot);

    Slot allocateSlot(LockerItem lockerItem);
}
