package test.Services;

import test.Models.Booking;
import test.Models.Flight;
import test.storage.FlightStorage;

import java.util.List;
import java.util.Map;

public class OrderService {

    public void bookFlight(List<Booking> bookings){

        // Instances
        FlightStorage flightStorage = FlightStorage.getFlightStorageInstance();

        // Variables
        Map<String, Flight> flights = flightStorage.getFlightData();

        bookings.forEach(booking -> {System.out.println(booking.toString());});
    }
}
