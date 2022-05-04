package test.storage;

import java.io.BufferedReader;
import java.util.List;
import java.io.FileNotFoundException;

import test.Models.Booking;

import org.junit.Test;
import org.junit.Before;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;


import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class BookingReaderBuilderTest {
    @InjectMocks
    private BookingReaderBuilder bookingReaderBuilderSUT;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void BookingReaderTest() throws Exception {

        String filePath = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/Sample.csv";

        List<Booking> buildRetReturnValue = bookingReaderBuilderSUT.build(filePath);
        Booking booking = new Booking("Sam", "SJ456", "Economy", 5, "5410000000000000");

        assertEquals(booking, buildRetReturnValue.get(0));
    }
}

