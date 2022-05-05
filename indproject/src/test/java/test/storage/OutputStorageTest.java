package test.storage;

import java.util.List;
import java.util.ArrayList;

import test.Models.Ticket;

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

public class OutputStorageTest {
    @Mock
    private List<String> errorOutputMock;
    @Mock
    private List<Ticket> ticketsMock;
    @InjectMocks
    private OutputStorage outputStorageSUT;

    @Before
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void errorOutputTest() throws Exception {
        String errorString = "errorString";

        boolean addReturnValue = false;
        when(errorOutputMock.add("errorString")).thenReturn(addReturnValue);
        outputStorageSUT.addError(errorString);

        assertEquals(false, addReturnValue);
    }

    @Test
    public void ticketOutputTest() throws Exception {
        Ticket ticket = null;
        boolean addReturnValue1 = false;
        when(ticketsMock.add((Ticket) null)).thenReturn(addReturnValue1);


        outputStorageSUT.addTicket(ticket);

        //3.Assert
        assertEquals(false, addReturnValue1);
    }
}

