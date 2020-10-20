package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightOffer implements Comparable {
    private int id;
    private int price;
    private String srcAirport;
    private String dstAirport;
    private int flightTime;

    @Override
    public int compareTo(Object o) {
        FlightOffer offer = (FlightOffer) o;
        return price = offer.price;
    }

    public boolean matches(String srcAirport, String dstAirport) {
        if (srcAirport.equalsIgnoreCase(srcAirport) && dstAirport.equalsIgnoreCase(dstAirport)) {
            return true;
        }
        return false;
    }
}