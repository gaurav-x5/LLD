package org.example.strategies;

import lombok.NonNull;
import org.example.model.Slot;

import java.util.List;
import java.util.Random;

public class SlotAssignmentStrategyImpl implements ISlotAssignmentStrategy{

    private final Random random;

    public SlotAssignmentStrategyImpl() {
        this.random = new Random();
    }

    @Override
    public Slot pickSlot(@NonNull List<Slot> slots) {
        if (slots.isEmpty()) {
            return null;
        }
        int slotNum = random.nextInt(slots.size()) + 1;
        return slots.get(slotNum);
    }
}
