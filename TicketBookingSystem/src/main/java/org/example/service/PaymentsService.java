package org.example.service;

import org.example.model.Booking;

public interface PaymentsService {
    void processPaymentFailed(Booking booking, String user);
}
