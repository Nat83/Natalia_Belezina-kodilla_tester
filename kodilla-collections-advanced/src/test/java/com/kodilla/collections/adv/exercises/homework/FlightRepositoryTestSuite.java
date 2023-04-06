package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightRepositoryTestSuite {

    FlightRepository flightRepository;

    @BeforeEach
    public void setUp(){
     flightRepository = new FlightRepository();
    }

    @Test
    public void canDisplayFlightsPerAirport(){

        System.out.println("List of flights for " + Airport.WARSAW + " is " +
                flightRepository.getFlightsTable(Airport.WARSAW));


        int numberOfFlights = flightRepository.getFlightsTable(Airport.WARSAW).size();
        assertEquals(4, numberOfFlights);
    }

}