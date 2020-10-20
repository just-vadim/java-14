package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class OfferManagerTest {
    OfferRepository repository = new OfferRepository();
    OfferManager manager = new OfferManager(repository);
    private FlightOffer firstOffer = new FlightOffer(1, 7000, "ABA", "DME", 180);
    private FlightOffer secondOffer = new FlightOffer(2, 5000, "VTB", "DME", 150);
    private FlightOffer thirdOffer = new FlightOffer(3, 5100, "ABA", "DME", 180);
    private FlightOffer fourthOffer = new FlightOffer(4, 3000, "VOG", "KRR",200);
    private FlightOffer fifthOffer = new FlightOffer(5, 6500, "ABA", "DME", 180);

    @BeforeEach
    public void setUp() {
        manager.add(firstOffer);
        manager.add(secondOffer);
        manager.add(thirdOffer);
        manager.add(fourthOffer);
        manager.add(fifthOffer);
    }

    @Test
    void shouldSortSingle() {
        FlightOffer[] expected = new FlightOffer[] {secondOffer};
        FlightOffer[] actual = manager.findAll("VTB", "DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortSeveral() {
        FlightOffer[] expected = new FlightOffer[] {thirdOffer, fifthOffer, firstOffer};
        FlightOffer[] actual = manager.findAll("ABA", "DME");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSortIfNotExist() {
        FlightOffer[] expected = new FlightOffer[] {};
        FlightOffer[] actual = manager.findAll("DME", "VTB");
        assertArrayEquals(expected, actual);
    }
}