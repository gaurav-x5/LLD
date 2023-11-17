package org.example.strategies;

import lombok.NonNull;
import org.example.model.LockerItem;
import org.example.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SlotFilteringStrategyImpl implements ISlotFilteringStrategy{
    @Override
    public @NonNull List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem) {
        return slots.stream()
                .filter(slot -> slot.getSize().canAccommodate(lockerItem.getSize()))
                .collect(Collectors.toList());
    }
}
