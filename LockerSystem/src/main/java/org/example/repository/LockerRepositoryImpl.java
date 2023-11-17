package org.example.repository;

import lombok.NonNull;
import org.example.exception.LockerAlreadyExistsException;
import org.example.model.Locker;
import org.example.model.Package;
import org.example.model.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class LockerRepositoryImpl implements ILockerRepository{

    private HashMap<String, Locker> lockers;

    public LockerRepositoryImpl() {
        this.lockers = new HashMap<>();
    }

    @Override
    public @NonNull Locker createLocker(@NonNull String id) {
        if (getLockerById(id) != null) {
            throw new LockerAlreadyExistsException();
        }
        final Locker newLocker = new Locker(id);
        lockers.put(id, newLocker);
        return newLocker;
    }

    @Override
    public @NonNull Locker getLockerById(@NonNull String id) {
        if (!lockers.containsKey(id))
            throw new NoSuchElementException();
        return lockers.get(id);
    }

    @Override
    public @NonNull List<Slot> getAllAvailableSlots() {
        final List<Slot> result = new ArrayList<>();
        for (Locker locker : lockers.values()) {
            result.addAll(locker.getAvailableSlots());
        }
        return result;
    }
}

