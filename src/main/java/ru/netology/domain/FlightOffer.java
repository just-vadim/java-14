package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightOffer {
    private int id;
    private int price;
    private String srcAirport;
    private String dstAirport;
    private int flightTime;
}
