package test.validator;

import test.Models.Booking;

public abstract class BaseValidator implements Validator{
    protected BaseValidator nextValidator;

    public void setNextValidator(BaseValidator nextValidator) {
        this.nextValidator = nextValidator;
    }

    public abstract void isValid(Booking booking);
}
