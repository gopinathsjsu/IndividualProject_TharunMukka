package test.validator;

import test.Models.Booking;

public class CardValidator extends BaseValidator {

    public CardValidator(){
        super();
    }

    @Override
    public void isValid(Booking booking){
        System.out.println("card valid");
    }
}
