package test.validator;

import test.Models.Booking;
import test.Models.CategoryAvailability;
import test.Models.Flight;
import test.storage.FlightStorage;
import test.storage.OutputStorage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeatValidator extends BaseValidator {

    public SeatValidator(){
        super();
    }

    @Override
    public void isValid(Booking booking){
        OutputStorage outputStorage = OutputStorage.getOutputStorageInstance();
        FlightStorage flightStorage = FlightStorage.getFlightStorageInstance();
        Map<String, Flight> flightMap = flightStorage.getFlightData();
        List<CategoryAvailability> categoryAvailabilities = flightMap.get(booking.getFlightNumber()).getCategoryAvailabilityList().
                stream().filter(u -> u. getCategory().equals(booking.getCategory())).collect(Collectors.toList());
        Boolean c = categoryAvailabilities.get(0).getSeats() >= booking.getSeats();
        if(categoryAvailabilities.get(0).getSeats() >= booking.getSeats()){
            // if required seats are available, call Card Validator
            this.nextValidator.isValid(booking);
        }
        else {
            // write to output error storage
            outputStorage.addError("Please enter correct booking details for " + booking.getBookingName() +
                    ": Not enough seats in selected category");
        }
    }
}
