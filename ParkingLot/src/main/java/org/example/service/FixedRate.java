package org.example.service;

import org.example.models.ParkingTicket;
import org.example.models.PaymentStatusEnum;
import org.example.repository.TicketRepo;

import java.time.Instant;

public class FixedRate implements PaymentStrategy {

    private final double rate = 2.0;

    @Override
    public ParkingTicket makePayment(ParkingTicket parkingTicket) {

        Instant start = parkingTicket.getEntranceTime();
        Instant end = Instant.now();

        double amount = ((end.toEpochMilli() - start.toEpochMilli()) / 1000.0) * rate;
        System.out.println("Total amount to be paid " + amount);
        parkingTicket.setAmount(amount);

//        assuming payment is done
        parkingTicket.setPaymentStatus(PaymentStatusEnum.PAID);
        TicketRepo.historyTicket.put(parkingTicket.getRegistrationId(), parkingTicket);
        System.out.println("Payment Success");
        return parkingTicket;
    }
}
