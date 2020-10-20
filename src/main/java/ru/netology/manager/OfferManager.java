package ru.netology.manager;

import ru.netology.domain.FlightOffer;
import ru.netology.repository.OfferRepository;

public class OfferManager {
    private OfferRepository repository;

    public OfferManager(OfferRepository repository) {
        this.repository = repository;
    }

    public void add(FlightOffer item) {
        repository.save(item);
    }

    public FlightOffer[] searchBy(String text) { //TODO Метод должен принимать на вход два параметра
        FlightOffer[] result = new FlightOffer[0];
        for (FlightOffer offer : repository.findAll()) {
            if (offer.matches(text)) {
                FlightOffer[] tmp = new FlightOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = offer;
                result = tmp;
            }
        }
        return result;
    }
}