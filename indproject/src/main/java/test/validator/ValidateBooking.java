package test.validator;

import test.Models.Booking;
import test.Models.Ticket;

public class ValidateBooking {

    protected static BaseValidator flightValidator = new FlightValidator();
    protected static BaseValidator seatValidator = new SeatValidator();
    protected static BaseValidator cardValidator = new CardValidator();
    protected static BaseValidator validatorChain;

    static {
        flightValidator.setNextValidator(seatValidator);
        seatValidator.setNextValidator(cardValidator);
        validatorChain = flightValidator;
    }

    public static void validate(Booking booking){
        if(booking.getFlightNumber() != null) {
            validatorChain.isValid(booking);
        }
    }
}
