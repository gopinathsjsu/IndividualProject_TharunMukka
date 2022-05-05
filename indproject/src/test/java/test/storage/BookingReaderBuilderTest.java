package test.storage;

import java.util.List;
import test.Models.Booking;
import org.junit.Test;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

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
        Booking booking = new Booking("Sam", "SJ456", "Economy", 2, "5410000000000000");

        assertEquals(booking, buildRetReturnValue.get(0));
    }
}

