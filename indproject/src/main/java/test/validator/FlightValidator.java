package test.validator;

import test.Models.Booking;
import test.Models.Flight;
import test.storage.FlightStorage;
import test.storage.OutputStorage;

import java.util.Map;

public class FlightValidator extends BaseValidator{
    public FlightValidator(){
        super();
    }

    @Override
    public void isValid(Booking booking){
        OutputStorage outputStorage = OutputStorage.getOutputStorageInstance();
//        FlightStorage flightStorage = FlightStorage.getFlightStorageInstance();
//        Map<String, Flight> flightMap = flightStorage.getFlightData();


        if(isFlightValid(booking.getFlightNumber())){
            // if flight exists, call seat validation step
            this.nextValidator.isValid(booking);
        }
        else {
            // write to output error storage
            outputStorage.addError("Please enter correct booking details for " + booking.getBookingName() +
                    ": Invalid Flight Number");
        }
    }

    public Boolean isFlightValid(String flightNumber) {
        FlightStorage flightStorage = FlightStorage.getFlightStorageInstance();
        Map<String, Flight> flightMap = flightStorage.getFlightData();
        if(flightMap.containsKey(flightNumber)){
            return true;
        }
        return false;
    }
}
