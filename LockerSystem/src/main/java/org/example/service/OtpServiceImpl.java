package org.example.service;

import lombok.NonNull;
import org.example.model.Slot;
import org.example.repository.ISlotOtpRepository;
import org.example.strategies.IOtpGenerator;

public class OtpServiceImpl implements OtpService {

    private final IOtpGenerator otpGenerator;
    private final ISlotOtpRepository slotOtpRepository;

    public OtpServiceImpl(IOtpGenerator iOtpGenerator, ISlotOtpRepository iSlotOtpRepository) {
        this.otpGenerator = iOtpGenerator;
        this.slotOtpRepository = iSlotOtpRepository;
    }

    @Override
    public boolean validate(Slot slot, String otp) {
        final String savedOtp = slotOtpRepository.getOtp(slot.getSlotId());
        return savedOtp != null && savedOtp.equals(otp);
    }

    @NonNull
    public String generateOtp(@NonNull final Slot slot) {
        final String otp = otpGenerator.generateOtp();
        slotOtpRepository.addOtp(otp, slot.getSlotId());
        return otp;
    }
}
