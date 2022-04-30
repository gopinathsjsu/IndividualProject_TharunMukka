package test.Services;

import test.Models.Booking;
import test.Models.CategoryAvailability;
import test.Models.Flight;
import test.Models.Ticket;
import test.storage.FlightStorage;
import test.storage.OutputStorage;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderService {

    public void bookFlight(Booking booking){

        // Instances
        FlightStorage flightStorage = FlightStorage.getFlightStorageInstance();
        OutputStorage outputStorage = OutputStorage.getOutputStorageInstance();

        // Variables
        Map<String, Flight> flights = flightStorage.getFlightData();


        try {
            Flight flight = flights.get(booking.getFlightNumber());
            Optional<CategoryAvailability> check = flight.getCategoryAvailabilityList().stream().filter(u-> u.getCategory().equals(booking.getCategory())).findFirst();
            Integer seats = flight.getCategoryAvailabilityList().stream().filter(u-> u.getCategory().equals(booking.getCategory())).findFirst().get().getSeats();
            flight.getCategoryAvailabilityList().stream().
                    filter(u -> u.getCategory().equals(booking.getCategory())).findFirst().get().
                    setSeats(seats - booking.getSeats());
            flightStorage.add(flight);
            outputStorage.addTicket(new Ticket(booking.getBookingName(), booking.getFlightNumber(), booking.getCategory(),
                    booking.getSeats(), check.get().getPrice() * booking.getSeats()));
            System.out.println(booking.toString());
        }
        catch (Exception ex){
            System.out.println(ex);
        }
//        bookings.forEach(booking -> {System.out.println(booking.toString());});
    }
}
