package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter

public class ParkingTicket {

    private String id;
    private Instant entranceTime;
    private Instant existTime;
    private Double amount;
    private String registrationId;
    private PaymentStatusEnum paymentStatus;

    private VehicleEnum vehicleEnum;

    public ParkingTicket(String id, Instant entranceTime, String registrationId, VehicleEnum vehicleEnum) {
        this.id = id;
        this.entranceTime = entranceTime;
        this.registrationId = registrationId;
        this.paymentStatus = PaymentStatusEnum.UNPAID;
        this.vehicleEnum = vehicleEnum;
    }


}
