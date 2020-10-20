package ru.netology.repository;
import ru.netology.domain.FlightOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferRepository {

    private FlightOffer[] offers = new FlightOffer[0];

    public FlightOffer[] findAll(){
        return offers;
    }

    public void save(FlightOffer item){
        int length = offers.length + 1;
        FlightOffer[] tmp = new FlightOffer[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        offers = tmp;
    }

    public FlightOffer[] findById(int id) {
        FlightOffer[] result = new FlightOffer[0];
        int index = 0;
        for (FlightOffer item : offers) {
            if (item.getId() == id) {
                int length = result.length + 1;
                FlightOffer[] tmp = new FlightOffer[length];
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = offers[index];
                result = tmp;
            }
            index++;
        }
        if (result.length == 0){
            return null;
        }
        else {
            return result;
        }
    }

    public void removeById(int id) {
        List<FlightOffer> list = new ArrayList<>(Arrays.asList(offers));
        FlightOffer[] removingItem = findById(id);
        if (removingItem == null){
            return;
        }
        list.remove(removingItem[0]);
        FlightOffer[] result = new FlightOffer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        offers = result;
    }

    public void removeAll(){
        offers = new FlightOffer[0];
    }
}