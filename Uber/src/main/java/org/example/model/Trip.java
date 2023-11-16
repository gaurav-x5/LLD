package org.example.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import static org.example.model.TripStatus.FINISHED;
import static org.example.model.TripStatus.IN_PROGRESS;

enum TripStatus {
    IN_PROGRESS,
    FINISHED
}

@ToString
public class Trip {
    private Rider rider;
    private Cab cab;
    @Setter @Getter
    private TripStatus status;
    private Double price;
    private Location fromPoint;
    private Location toPoint;

    public Trip(
            @NonNull final Rider rider,
            @NonNull final Cab cab,
            @NonNull final Double price,
            @NonNull final Location fromPoint,
            @NonNull final Location toPoint) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.status = IN_PROGRESS;
    }

    public void endTrip() {
        this.status = FINISHED;
    }
}
