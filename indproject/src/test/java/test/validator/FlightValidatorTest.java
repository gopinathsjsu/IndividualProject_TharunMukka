package test.validator;

import java.util.Map;

import test.Models.Flight;
import test.Models.Booking;
import test.storage.FlightStorage;
import test.storage.OutputStorage;
import test.validator.BaseValidator;

import org.junit.Test;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class FlightValidatorTest {
    @Mock
    private BaseValidator nextValidatorMock;
    @InjectMocks
    private FlightValidator flightValidatorSUT;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void when_xx_then_success_isValid() throws Exception {
        String flightNumber = "SJ456";
        Boolean valid = flightValidatorSUT.isFlightValid(flightNumber);

        assertEquals(false, valid);
    }
}

