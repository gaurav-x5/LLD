package org.example.service;

import org.example.exception.NoSlotAvailableException;
import org.example.model.Locker;
import org.example.model.LockerItem;
import org.example.model.Size;
import org.example.model.Slot;
import org.example.repository.ILockerRepository;
import org.example.strategies.ISlotAssignmentStrategy;
import org.example.strategies.ISlotFilteringStrategy;

import java.util.List;
import java.util.UUID;

public class LockerServiceImpl implements LockerService {
    private final ILockerRepository lockerRepository;
    private final ISlotFilteringStrategy slotFilteringStrategy;
    private final ISlotAssignmentStrategy slotAssignmentStrategy;

    public LockerServiceImpl(ILockerRepository lockerRepository, ISlotFilteringStrategy slotFilteringStrategy,
                             ISlotAssignmentStrategy slotAssignmentStrategy) {
        this.lockerRepository = lockerRepository;
        this.slotFilteringStrategy = slotFilteringStrategy;
        this.slotAssignmentStrategy = slotAssignmentStrategy;
    }

    @Override
    public Locker createLocker(String lockerId) {
        return lockerRepository.createLocker(lockerId);
    }

    @Override
    public Slot createSlot(String lockerId, Size slotSize) {
        Locker locker = lockerRepository.getLockerById(lockerId);
        String slotId = UUID.randomUUID().toString();
        Slot slot = new Slot(slotId, slotSize, locker);
        locker.addSlot(slot);
        return slot;
    }

    @Override
    public List<Slot> getAllAvailableSlots() {
        return lockerRepository.getAllAvailableSlots();
    }

    @Override
    public void deallocateSlot(Slot slot) {
        slot.deallocateSlot();
    }

    @Override
    public Slot allocateSlot(LockerItem lockerItem) {
        List<Slot> allAvailableSlots = lockerRepository.getAllAvailableSlots();
        List<Slot> filteredSlots = slotFilteringStrategy.filterSlots(allAvailableSlots, lockerItem);
        Slot slot = slotAssignmentStrategy.pickSlot(filteredSlots);

        if(slot == null) {
            throw new NoSlotAvailableException();
        }

        slot.AllocateSlot(lockerItem);
        return slot;
    }
}
