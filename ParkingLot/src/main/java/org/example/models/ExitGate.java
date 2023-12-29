package org.example.models;

import lombok.Getter;
import org.example.exception.InvalidTicket;
import org.example.repository.ParkingSpotRepo;
import org.example.repository.TicketRepo;
import org.example.service.PaymentStrategy;

@Getter
public class ExitGate {
    private int id;

    PaymentStrategy paymentStrategy;

    public ExitGate(int id, PaymentStrategy paymentStrategy) {
        this.id = id;
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processParkingTicket(String ticketId) {
        ParkingTicket parkingTicket = TicketRepo.activeTicket.get(ticketId);
        if(parkingTicket == null) throw new InvalidTicket("Ticket is Not valid");

        boolean status =  paymentStrategy.makePayment(parkingTicket).getPaymentStatus() == PaymentStatusEnum.PAID;
        if (status) {
            ParkingSpotRepo.vacantSpots.put(getSpot(parkingTicket.getVehicleEnum()),
                    ParkingSpotRepo.vacantSpots.get(getSpot(parkingTicket.getVehicleEnum())) -1);
            System.out.printf("Exit Success for Vehicle with ticketId " + ticketId);
        }
        return status;
    }

    private SpotEnum getSpot(VehicleEnum vehicleEnum) {
        if(vehicleEnum == VehicleEnum.CAR || vehicleEnum == VehicleEnum.VAN)
            return SpotEnum.COMPACT;
        else if(vehicleEnum == VehicleEnum.MOTORCYCLE) return SpotEnum.MOTORCYCLE;
        else if(vehicleEnum == VehicleEnum.TRUCK) return SpotEnum.LARGE;
        return SpotEnum.HANDICAPPED;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

}
