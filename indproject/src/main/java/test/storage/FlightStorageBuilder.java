package test.storage;

import test.Models.CategoryAvailability;
import test.Models.Flight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Builder Pattern
public class FlightStorageBuilder {
// read csv and call flight storage add method

    public void build(String filePath) throws IOException {
        String line="";
        Boolean header = false;
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        FlightStorage flightStorage = FlightStorage.getFlightStorageInstance();
        Map<String, Flight> flights = flightStorage.getFlightData();
        while((line= br.readLine()) != null) {
            if(!header){
                header= true;
            }
            else {
                String[] flightArray = line.split(",");
                String category = flightArray[0];
                String flightNumber = flightArray[1];
                Integer seats = Integer.parseInt(flightArray[2]);
                Double price = Double.parseDouble(flightArray[3]);
                String arrival = flightArray[4];
                String departure = flightArray[5];

                if(flights.containsKey(flightArray[1])) {
                    Flight updateFlight = flights.get(flightNumber);
                    CategoryAvailability categoryAvailability = new CategoryAvailability(category, seats, price);
                    List<CategoryAvailability> categoryAvailabilityList = updateFlight.getCategoryAvailabilityList();
                    categoryAvailabilityList.add(categoryAvailability);
                    updateFlight.setCategoryAvailabilityList(categoryAvailabilityList);
//                    flights.put(flightNumber, updateFlight);
                    flightStorage.add(updateFlight);
                }
                else {
                    Flight flight = new Flight();
                    List<CategoryAvailability> categoryAvailabilityList = new ArrayList<>();
                    CategoryAvailability categoryAvailability = new CategoryAvailability(category, seats, price);
                    categoryAvailabilityList.add(categoryAvailability);
//                    flights.put(flightNumber, new Flight(flightNumber, categoryAvailabilityList, arrival, departure));
                    flightStorage.add(new Flight(flightNumber, categoryAvailabilityList, arrival, departure));
                }
//                Flight flight = new Flight();
////                String category = flightArray[0];
//                String flightNumber = flightArray[1];
////                Integer seats = Integer.parseInt(flightArray[2]);
////                Double price = Double.parseDouble(flightArray[3]);
//                String arrival = flightArray[4];
//                String departure = flightArray[5];

//                flightStorage.add(new Flight(flightNumber, category,seats, price, arrival, departure));
            }
        }
        printFlightData(flightStorage.getFlightData());
    }

    public void printFlightData(Map<String,Flight> map){
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }

    }
}
