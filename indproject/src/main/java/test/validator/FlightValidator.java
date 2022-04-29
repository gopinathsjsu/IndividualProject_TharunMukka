package test.validator;

import test.Models.Booking;

public class FlightValidator extends BaseValidator{
    public FlightValidator(){
        super();
    }

    @Override
    public void isValid(Booking booking){
        System.out.println("card valid");
    }
}
