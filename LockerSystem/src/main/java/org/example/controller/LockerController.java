package org.example.controller;

import lombok.NonNull;
import org.example.model.Locker;
import org.example.model.Size;
import org.example.model.Slot;
import org.example.service.LockerService;
import org.example.service.OtpService;

import java.util.List;

public class LockerController {

    private final LockerService lockerService;
    private final OtpService otpService;

    public LockerController(LockerService lockerService, OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(@NonNull final String lockerId) {
        return lockerService.createLocker(lockerId);
    }

    public Slot createSlot(@NonNull final String lockerId, @NonNull final Size slotSize) {
        return lockerService.createSlot(lockerId, slotSize);
    }

    public List<Slot> getAvailableSlots() {
        return lockerService.getAllAvailableSlots();
    }

    public boolean unLockLocker(@NonNull Slot slot, @NonNull final String otp) {
        return otpService.validate(slot, otp);
    }

    public void deallocateSlot(@NonNull final Slot slot) {
        lockerService.deallocateSlot(slot);
    }
}
