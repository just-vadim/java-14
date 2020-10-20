package ru.netology.comparator;

import ru.netology.domain.FlightOffer;

import java.util.Comparator;

public class FlightOfferByFlightTimeAscComparator implements Comparator<FlightOffer> {

    @Override
    public int compare(FlightOffer o1, FlightOffer o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}