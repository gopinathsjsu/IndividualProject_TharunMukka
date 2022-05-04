package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.Models.Booking;
import test.Models.Flight;
import test.Writer.OutputFactory;
import test.Writer.Writer;
import test.storage.BookingReaderBuilder;
import test.storage.FlightStorage;
import test.storage.FlightStorageBuilder;
import test.validator.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class RunClient {

//	public void outputTickerWriter(List<Booking> bookings) throws FileNotFoundException {
//		String output = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/Output.csv";
//		PrintWriter pw = new PrintWriter(new File(output));
//
//		StringBuilder builder = new StringBuilder();
//		String columnNamesList = "BookingName, FlightNumber, Category, number of seats, total price";
//		builder.append(columnNamesList +"\n");
//		for(Booking booking: bookings){
//			builder.append(booking.getBookingName()+","+booking.getFlightNumber()+","+booking.getCategory()+","+
//					booking.getSeats()+","+"123"+","+"\n");
//		}
//		pw.write(builder.toString());
//		pw.close();
//		System.out.println("ticket csv file done!");
//	}
//
//	public void outputErrorWriter() throws FileNotFoundException {
//		List<String> outputs = Arrays.asList("Please enter correct booking details for John: invalid flight number",
//				"Please enter correct booking details for Jake: invalid card number");
//		String output = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/Output.txt";
//		PrintWriter pw = new PrintWriter(new File(output));
//		StringBuilder builder = new StringBuilder();
//
//		for(String out:outputs){
//			builder.append(out+"\n");
//		}
//		pw.write(builder.toString());
//		pw.close();
//		System.out.println("error output file done!");
//	}

	public static void main(String[] args) throws IOException {
		System.out.println(args.length + " params received");
		Arrays.stream(args).forEach(System.out::println);
//		String flightsPath = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/flights.csv";
//		String bookingsFilePath = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/Sample.csv";
//		String outputBookingFilePath = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/Output.csv";
//		String outputErrorFilePath = "/Users/tharunmukka/Desktop/Master's/sem2/softwaresys/individual/IndividualProject_TharunMukka/indproject/Output.txt";
		String bookingsFilePath = args[0];
		String flightsPath = args[1];
		String outputBookingFilePath = args[2];
		String outputErrorFilePath = args[3];

//		OutputStorage outputStorage = OutputStorage.getOutputStorageInstance();
		FlightStorageBuilder flightStorageBuilder = new FlightStorageBuilder();
//		FlightStorage flightStorage = FlightStorage.getFlightStorageInstance();
		flightStorageBuilder.build(flightsPath);
//		Map<String, Flight> flights = flightStorage.getFlightData();

		BookingReaderBuilder bookingsReaderBuilder = new BookingReaderBuilder();
		List<Booking> bookingList = bookingsReaderBuilder.build(bookingsFilePath);

//		OrderService orderService = new OrderService();
//		orderService.bookFlight(bookingList.get(0);

//		RunClient runClient = new RunClient();
//		runClient.outputTickerWriter(bookingList);
//		runClient.outputErrorWriter();

		// validate booking
		for (Booking booking : bookingList) {
			ValidateBooking.validate(booking);
		}

		// writing output
		OutputFactory outputFactory = new OutputFactory();
		Writer ticketWriter =  outputFactory.getOutputWriter("Tickets");
		Writer errorWriter = outputFactory.getOutputWriter("Error");
//		List<String> outerror = outputStorage.getErrorOutput();
//		List<Ticket> tickets = outputStorage.getTickets();
		ticketWriter.outputWriter(outputBookingFilePath);
		errorWriter.outputWriter(outputErrorFilePath);

		SpringApplication.run(RunClient.class, args);
	}

}