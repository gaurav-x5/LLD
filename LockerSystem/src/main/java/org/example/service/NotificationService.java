package org.example.service;

import org.example.model.Buyer;
import org.example.model.LockerUser;
import org.example.model.Slot;

public interface NotificationService {
    void notifyUser(LockerUser buyer, String otp, Slot slot);
}
