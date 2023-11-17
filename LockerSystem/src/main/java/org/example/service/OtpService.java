package org.example.service;

import org.example.model.Slot;

public interface OtpService {
    boolean validate(Slot slot, String otp);

    String generateOtp(Slot slot);
}
