package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightOffer implements Comparable<FlightOffer> {
    private int id;
    private int price;
    private String srcAirport;
    private String dstAirport;
    private int flightTime;

    @Override
    public int compareTo(FlightOffer o) {
        FlightOffer offer = (FlightOffer) o;
        return price - offer.price;
    }

    public boolean matches(String src, String dst) {
        if (src.equalsIgnoreCase(srcAirport) && dst.equalsIgnoreCase(dstAirport)) {
            return true;
        }
        return false;
    }
}