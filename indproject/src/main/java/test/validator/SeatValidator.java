package test.validator;

import test.Models.Booking;

public class SeatValidator extends BaseValidator {

    public SeatValidator(){
        super();
    }

    @Override
    public void isValid(Booking booking){
        System.out.println("card valid");
    }
}
