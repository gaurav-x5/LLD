package org.example.service;

import org.example.models.ParkingTicket;

public interface PaymentStrategy {

    public ParkingTicket makePayment(ParkingTicket parkingTicket);
}
