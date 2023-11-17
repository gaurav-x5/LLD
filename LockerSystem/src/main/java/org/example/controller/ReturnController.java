package org.example.controller;

import lombok.NonNull;
import org.example.model.Buyer;
import org.example.model.DeliveryPerson;
import org.example.model.LockerItem;
import org.example.model.Slot;
import org.example.service.DeliveryPersonService;
import org.example.service.LockerService;
import org.example.service.NotificationService;
import org.example.service.OtpService;

public class ReturnController {

    private final OtpService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;
    private final DeliveryPersonService deliveryPersonService;

    public ReturnController(@NonNull final NotificationService notificationService,
                            @NonNull final OtpService otpService,
                            @NonNull final LockerService lockerService,
                            @NonNull final DeliveryPersonService deliveryPersonService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
        this.deliveryPersonService = deliveryPersonService;
    }

    public void allocateLocker(@NonNull final Buyer buyer, @NonNull final LockerItem lockerItem) {
        final Slot slot = lockerService.allocateSlot(lockerItem);
        final String otp = otpService.generateOtp(slot);
        final DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(slot);
        notificationService.notifyUser(deliveryPerson, otp, slot);
    }
}
