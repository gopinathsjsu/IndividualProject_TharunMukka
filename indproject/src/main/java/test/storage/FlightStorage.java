package test.storage;

import test.Models.Flight;

import java.util.HashMap;
import java.util.Map;

public class FlightStorage {
    private Map<String, Flight> flightData;
    private static FlightStorage flightStorageInstance;

    private FlightStorage(){
        flightData = new HashMap<>();
    }

    public static FlightStorage getFlightStorageInstance(){
        if(flightStorageInstance == null) {
            flightStorageInstance = new FlightStorage();
        }
        return flightStorageInstance;
    }

    public boolean add(Flight flight){
        flightData.put(flight.getFlightNumber(), flight);
        return true;
    }

    public Map<String, Flight> getFlightData(){
        return flightData;
    }
}
