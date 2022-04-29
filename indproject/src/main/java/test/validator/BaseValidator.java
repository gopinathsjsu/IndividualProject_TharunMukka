package test.validator;

import test.Models.Booking;

public abstract class BaseValidator implements Validator{
    protected BaseValidator baseValidator;

    public void setNextValidator(BaseValidator baseValidator) {
        this.baseValidator = baseValidator;
    }

    public abstract void isValid(Booking booking);
}
