package test.storage;

import java.util.Map;

import test.Models.Flight;

import java.util.HashMap;

import org.junit.Test;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FlightStorageTest {
    @Mock
    private Map<String, Flight> flightDataMock;
    @InjectMocks
    private FlightStorage flightStorageSUT;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addFlightTest() throws Exception {

        Flight flight = new Flight();

        Flight putReturnValue = new Flight();
        when(flightDataMock.put("flight.getFlightNumber()", new Flight())).thenReturn(putReturnValue);
        boolean addRetReturnValue = flightStorageSUT.add(flight);

        boolean sutExpected = true;
        assertEquals(sutExpected, addRetReturnValue);
    }

    @Test
    public void singletonObjectTest(){
        FlightStorage first = FlightStorage.getFlightStorageInstance();
        FlightStorage second = FlightStorage.getFlightStorageInstance();

        // check both the objects are same, which shows only one instance is existing
        assertEquals(first, second);
    }
}

