package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.FlightOfferByFlightTimeAscComparator;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class OfferManagerTest {
    OfferRepository repository = new OfferRepository();
    OfferManager manager = new OfferManager(repository);
    FlightOfferByFlightTimeAscComparator comparator = new FlightOfferByFlightTimeAscComparator();
    private FlightOffer firstOffer = new FlightOffer(1, 7000, "ABA", "DME", 180);
    private FlightOffer secondOffer = new FlightOffer(2, 5000, "VTB", "DME", 150);
    private FlightOffer thirdOffer = new FlightOffer(3, 7000, "ABA", "DME", 170);
    private FlightOffer fourthOffer = new FlightOffer(4, 3000, "VOG", "KRR",200);
    private FlightOffer fifthOffer = new FlightOffer(5, 6500, "ABA", "DME", 190);
    private FlightOffer sixthOffer = new FlightOffer(6, 5000, "VTB", "DME", 150);

    @BeforeEach
    public void setUp() {
        manager.add(firstOffer);
        manager.add(secondOffer);
        manager.add(thirdOffer);
        manager.add(fourthOffer);
        manager.add(fifthOffer);
        manager.add(sixthOffer);
    }

    @Test
    void shouldFindSingle() {
        FlightOffer[] expected = new FlightOffer[] {fourthOffer};
        FlightOffer[] actual = manager.findAll("VOG", "KRR", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSeveral() {
        FlightOffer[] expected = new FlightOffer[] {thirdOffer, firstOffer , fifthOffer};
        FlightOffer[] actual = manager.findAll("ABA", "DME", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIfIdentical() {
        FlightOffer[] expected = new FlightOffer[] {secondOffer, sixthOffer};
        FlightOffer[] actual = manager.findAll("VTB", "DME", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindIfNotExist() {
        FlightOffer[] expected = new FlightOffer[] {};
        FlightOffer[] actual = manager.findAll("DME", "VTB", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindIfRepositoryIsEmpty() {
        repository.removeAll();
        FlightOffer[] expected = new FlightOffer[] {};
        FlightOffer[] actual = manager.findAll("VOG", "KRR", comparator);
        assertArrayEquals(expected, actual);
    }
}