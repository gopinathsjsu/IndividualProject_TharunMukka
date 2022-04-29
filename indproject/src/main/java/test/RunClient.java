package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.Models.Booking;
import test.Models.Flight;
import test.Services.OrderService;
import test.storage.BookingReaderBuilder;
import test.storage.FlightStorage;
import test.storage.FlightStorageBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SpringBootApplication
public class RunClient {

	public static void main(String[] args) throws IOException {
		args= new String[] { "hi","hello","hey" };
		Arrays.stream(args).forEach(System.out::println);
		String filePath = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/flights.csv";
		String bookingFilePath = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/Sample.csv";
//		Scanner sc = new Scanner(new File("/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/flights.csv"));
//		sc.useDelimiter(",");
//
//		while (sc.hasNext())  //returns a boolean value
//		{
//			System.out.print(sc.next());  //find and returns the next complete token from this scanner
//		}
//		sc.close();  //closes the scanner

		FlightStorageBuilder flightStorageBuilder = new FlightStorageBuilder();
		FlightStorage flightStorage = FlightStorage.getFlightStorageInstance();
		flightStorageBuilder.build(filePath);
		Map<String, Flight> flights = flightStorage.getFlightData();

		BookingReaderBuilder bookingReaderBuilder = new BookingReaderBuilder();
		List<Booking> bookingList = bookingReaderBuilder.build(bookingFilePath);

		OrderService orderService = new OrderService();
		orderService.bookFlight(bookingList);

		SpringApplication.run(RunClient.class, args);
	}

}
