package test.storage;

import test.Models.Flight;

import java.util.Map;

public interface Builder {
    Boolean add(Flight flight);
    Map<String, Flight> getFlightData();
}
