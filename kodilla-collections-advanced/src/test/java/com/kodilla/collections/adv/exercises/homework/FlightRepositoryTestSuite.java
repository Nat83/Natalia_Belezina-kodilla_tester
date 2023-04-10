package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightRepositoryTestSuite {

    FlightRepository flightRepository;

    @BeforeEach
    public void setUp(){
     flightRepository = new FlightRepository();
    }

    @Test
    public void canDisplayCorrectNumberOfFlightsPerAirport(){

        System.out.println("List of flights for " + Airport.WARSAW + " is " +
                flightRepository.getFlightsTable("WARSAW"));
        System.out.println("List of flights for " + Airport.LODZ + " is " +
                flightRepository.getFlightsTable("LODZ"));
        System.out.println("List of flights for " + Airport.WROCLAW + " is " +
                flightRepository.getFlightsTable("WROCLAW"));
        System.out.println("List of flights for " + Airport.KATOWICE + " is " +
                flightRepository.getFlightsTable("KATOWICE"));
        System.out.println("List of flights for " + Airport.KRAKOW + " is " +
                flightRepository.getFlightsTable("KRAKOW"));

        int numberOfWarsawFlights = flightRepository.getFlightsTable("WARSAW").size();
        int numberOfLodzFlights = flightRepository.getFlightsTable("LODZ").size();
        int numberOfWroclawFlights = flightRepository.getFlightsTable("WROCLAW").size();
        int numberOfKatowiceFlights = flightRepository.getFlightsTable("KATOWICE").size();
        int numberOfKrakowFlights = flightRepository.getFlightsTable("KRAKOW").size();

        assertEquals(4, numberOfWarsawFlights);
        assertEquals(1, numberOfLodzFlights);
        assertEquals(4, numberOfWroclawFlights);
        assertEquals(2, numberOfKatowiceFlights);
        assertEquals(1, numberOfKrakowFlights);
    }

    @Test
    public void canReturnEmptyListForIncorrectAirport(){

        List<Flight> emptyFlightListForIncorrectAirport = flightRepository.getFlightsTable("GDANSK");
        int numberOfFlightsForIncorrectAirport = flightRepository.getFlightsTable("GDANSK").size();

        assertEquals(Collections.emptyList(), emptyFlightListForIncorrectAirport);
        assertEquals(0, numberOfFlightsForIncorrectAirport);
    }
}