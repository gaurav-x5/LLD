package org.example.strategies;

import lombok.NonNull;

import java.util.Random;

public class OtpGeneratorStrategyImpl implements IOtpGenerator {

    private final int sizeOfOtp;
    private final Random random;

    public OtpGeneratorStrategyImpl(int sizeOfOtp) {
        this.sizeOfOtp = sizeOfOtp;
        random = new Random();
    }

    @Override
    public @NonNull String generateOtp() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sizeOfOtp; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }
}
