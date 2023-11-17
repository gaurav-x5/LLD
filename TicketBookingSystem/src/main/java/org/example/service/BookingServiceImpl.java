package org.example.service;

import lombok.NonNull;
import org.example.exceptions.BadRequestException;
import org.example.exceptions.NotFoundException;
import org.example.exceptions.SeatPermanentlyUnavailableException;
import org.example.model.Booking;
import org.example.model.BookingStatus;
import org.example.model.Seat;
import org.example.model.Show;
import org.example.provider.SeatLockProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    private final Map<String, Booking> bookings;
    private final SeatLockProvider seatLockProvider;

    public BookingServiceImpl(SeatLockProvider seatLockProvider) {
        this.bookings = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    @Override
    public Booking createBooking(String userId, Show show, List<Seat> seats) {
        if (isAnySeatAlreadyBooked(show, seats)) {
            throw new SeatPermanentlyUnavailableException();
        }
        seatLockProvider.lockSeats(show, seats, userId);
        final String bookingId = UUID.randomUUID().toString();
        final Booking newBooking = new Booking(bookingId, show, seats, userId);
        bookings.put(bookingId, newBooking);
        return newBooking;
    }

    public List<Booking> getAllBookings(final Show show) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if(booking.getShow().equals(show))
                response.add(booking);
        }

        return response;
    }

    public List<Seat> getBookedSeats(@NonNull final Show show) {
        return getAllBookings(show).stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeatsBooked)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private boolean isAnySeatAlreadyBooked(final Show show, final List<Seat> seats) {
        final List<Seat> bookedSeats = getBookedSeats(show);
        for(Seat seat : seats) {
            if (bookedSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Booking getBooking(String bookingId) {
        if (!bookings.containsKey(bookingId)) {
            throw new NotFoundException();
        }
        return bookings.get(bookingId);
    }

    @Override
    public void confirmBooking(Booking booking, String user) {
        if (!booking.getUser().equals(user)) {
            throw new BadRequestException();
        }

        for (Seat seat : booking.getSeatsBooked()) {
            if(!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
                throw new BadRequestException();
            }
        }

        booking.confirmBooking();
    }
}
