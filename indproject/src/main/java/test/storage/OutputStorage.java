package test.storage;

import test.Models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class OutputStorage {
    private List<String> errorOutput;
    private List<Ticket> tickets;
    private static OutputStorage outputStorageInstance;

    private OutputStorage(){
         errorOutput = new ArrayList<>();
         tickets = new ArrayList<>();
    }

    public static OutputStorage getOutputStorageInstance(){
        if(outputStorageInstance == null) {
            outputStorageInstance = new OutputStorage();
        }
        return outputStorageInstance;
    }

    public void addError(String errorString){
        errorOutput.add(errorString);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<String> getErrorOutput(){
        return errorOutput;
    }

    public List<Ticket> getTickets(){
        return tickets;
    }
}
