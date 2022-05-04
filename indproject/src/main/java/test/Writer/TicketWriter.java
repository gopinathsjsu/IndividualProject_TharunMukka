package test.Writer;

import test.Models.Booking;
import test.Models.Ticket;
import test.storage.OutputStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class TicketWriter implements Writer{
    public String outputWriter(String path) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(path));
        OutputStorage outputStorage = OutputStorage.getOutputStorageInstance();

        StringBuilder builder = new StringBuilder();
        String columnNamesList = "BookingName, FlightNumber, Category, number of seats, total price";
        builder.append(columnNamesList +"\n");
        for(Ticket ticket: outputStorage.getTickets()){
            builder.append(ticket.getBookingName()+","+ticket.getFlightNumber()+","+ticket.getCategory()+","+
                    ticket.getSeats()+","+ticket.getTotalPrice()+","+"\n");
        }
        pw.write(builder.toString());
        pw.close();
        System.out.println("ticket csv file writing done!");
        return "Successfully written Tickets";
    }
}
