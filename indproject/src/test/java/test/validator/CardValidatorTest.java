package test.validator;

import test.Services.OrderService;
import test.Models.Booking;
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

public class CardValidatorTest {
    @Mock
    private BaseValidator nextValidatorMock;
    @InjectMocks
    private CardValidator cardValidatorSUT;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void cardValidationTest() throws Exception {
        String cardNumber = "341000000000000";
        Boolean sutExpected = true;

        Boolean cardValidationHelperRetReturnValue = cardValidatorSUT.cardValidationHelper(cardNumber);
        assertEquals(sutExpected, cardValidationHelperRetReturnValue);
    }
}

