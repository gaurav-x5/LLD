package org.example.api;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.service.BookingService;
import org.example.service.PaymentsService;

@AllArgsConstructor
public class PaymentController {
    private final PaymentsService paymentsService;
    private final BookingService bookingService;

    public void paymentFailed(@NonNull final String bookingId, @NonNull final String user) {
        paymentsService.processPaymentFailed(bookingService.getBooking(bookingId), user);
    }

    public void paymentSuccess(@NonNull final String bookingId, @NonNull final String user) {
        bookingService.confirmBooking(bookingService.getBooking(bookingId), user);
    }


}
