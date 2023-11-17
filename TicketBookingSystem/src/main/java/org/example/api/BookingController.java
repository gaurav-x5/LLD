package org.example.api;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Booking;
import org.example.model.Seat;
import org.example.model.Show;
import org.example.service.BookingService;
import org.example.service.SeatService;
import org.example.service.ShowService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingController {

    private final ShowService showService;
    private final SeatService seatService;
    private final BookingService bookingService;


    public Booking createBooking(@NonNull final String userId, @NonNull final String showId,
                                 @NonNull final List<String> seatIds) {

        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatIds.stream().map(seatService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seats);
    }
}
