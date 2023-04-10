package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FlightFinderTestSuite {
    FlightFinder flightFinder;

    @BeforeEach
    public void setUp() {
        flightFinder = new FlightFinder();
    }

    @Test
    public void canFindCorrectNumbersOfFlightsByDeparture() {

        int NumberOfAllFlightFromWarsaw = flightFinder.findFlightsFrom("WARSAW").size();
        int NumberOfAllFlightFromKatowice = flightFinder.findFlightsFrom("KATOWICE").size();
        int NumberOfAllFlightFromLodz = flightFinder.findFlightsFrom("LODZ").size();
        int NumberOfAllFlightFromWroclaw = flightFinder.findFlightsFrom("WROCLAW").size();
        int NumberOfAllFlightFromKrakow = flightFinder.findFlightsFrom("KRAKOW").size();

        assertEquals(3, NumberOfAllFlightFromWarsaw);
        assertEquals(1, NumberOfAllFlightFromKatowice);
        assertEquals(0, NumberOfAllFlightFromLodz);
        assertEquals(2, NumberOfAllFlightFromWroclaw);
        assertEquals(0, NumberOfAllFlightFromKrakow);
    }

    @Test
    public void canFindCorrectNumbersOfFlightsByArrival() {

        int NumberOfAllFlightsToWarsaw = flightFinder.findFlightsTo("WARSAW").size();
        int NumberOfAllFlightsToKatowice = flightFinder.findFlightsTo("KATOWICE").size();
        int NumberOfAllFlightsToLodz = flightFinder.findFlightsTo("LODZ").size();
        int NumberOfAllFlightsToWroclaw = flightFinder.findFlightsTo("WROCLAW").size();
        int NumberOfAllFlightToKrakow = flightFinder.findFlightsTo("KRAKOW").size();

        assertEquals(1, NumberOfAllFlightsToWarsaw);
        assertEquals(1, NumberOfAllFlightsToKatowice);
        assertEquals(1, NumberOfAllFlightsToLodz);
        assertEquals(2, NumberOfAllFlightsToWroclaw);
        assertEquals(0, NumberOfAllFlightToKrakow);
    }

    @Test
    public void canFindCorrectListOfFlightsWithGivenDeparture() {

        List<Flight> AllFlightsFromKatowice = flightFinder.findFlightsFrom("KATOWICE");
        List<Flight> AllFlightsFromFromWroclaw = flightFinder.findFlightsFrom("WROCLAW");

        assertEquals("[Flight{departure='KATOWICE', arrival='WROCLAW'}]", AllFlightsFromKatowice.toString());
        assertEquals("[Flight{departure='WROCLAW', arrival='KATOWICE'}, " +
                "Flight{departure='WROCLAW', arrival='WARSAW'}]", AllFlightsFromFromWroclaw.toString());
    }

    @Test
    public void canFindListOfFlightsWithGiverArrival() {
        List<Flight> AllFlightsToWarsaw = flightFinder.findFlightsTo("WARSAW");
        List<Flight> AllFlightsToWroclaw = flightFinder.findFlightsTo("WROCLAW");

        assertEquals("[Flight{departure='WROCLAW', arrival='WARSAW'}]", AllFlightsToWarsaw.toString());
        assertEquals("[Flight{departure='WARSAW', arrival='WROCLAW'}, " +
                "Flight{departure='KATOWICE', arrival='WROCLAW'}]", AllFlightsToWroclaw.toString());
    }
}