package test.storage;

import test.Models.Booking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookingReaderBuilder {
    public List<Booking> build(String filePath) throws IOException {
        String line="";
        Boolean header = false;
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        List<Booking> bookingList = new ArrayList<>();

        while((line= br.readLine()) != null) {
            if(!header){
                header= true;
            }
            else {
                String[] bookingArray = line.split(",");

                String bookingName = bookingArray[0];
                String flightNumber = bookingArray[1];
                String category = bookingArray[2];
                Integer seats = Integer.parseInt(bookingArray[3]);
                String cardNumber = bookingArray[4];

                bookingList.add(new Booking(bookingName, flightNumber, category, seats, cardNumber));
            }
        }

        return bookingList;
    }
}
