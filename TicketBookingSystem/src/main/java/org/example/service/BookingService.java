package org.example.service;

import lombok.NonNull;
import org.example.model.Booking;
import org.example.model.Seat;
import org.example.model.Show;

import java.util.List;

public interface BookingService {

    public Booking createBooking(String userId, Show show, List<Seat> seats);

    Booking getBooking(String bookingId);

    void confirmBooking(Booking booking, String user);
    public List<Seat> getBookedSeats(@NonNull final Show show);
}
