package test.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    private String flightNumber;
//    private String category;
//    private Integer availableSeats;
//    private Double price;
    private List<CategoryAvailability> categoryAvailabilityList;
    private String arrival;
    private String departure;
}
