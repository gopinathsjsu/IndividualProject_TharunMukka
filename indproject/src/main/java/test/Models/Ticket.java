package test.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ticket {
    private String bookingName;
    private String flightNumber;
    private String category;
    private Integer seats;
    private Double totalPrice;
}
