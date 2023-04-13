package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlightRepository {

    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        flightRepository.getFlightsTable("WARSAW");
    }

    public static List<Flight> getFlightsTable(String airport) {
        List<Flight> allFlights = new ArrayList<>();

        allFlights.add(new Flight("WARSAW", "WROCLAW"));
        allFlights.add(new Flight("WARSAW", "KRAKOW"));
        allFlights.add(new Flight("WARSAW", "LODZ"));
        allFlights.add(new Flight("WROCLAW", "KATOWICE"));
        allFlights.add(new Flight("KATOWICE", "WROCLAW"));
        allFlights.add(new Flight("WROCLAW", "WARSAW"));

        List<Flight> flightsPerAirport = new ArrayList<>();
        for (Flight singleFlight : allFlights) {
            if (airport.equals(singleFlight.getDeparture()) || airport.equals(singleFlight.getArrival())) {
                flightsPerAirport.add(singleFlight);
            }
        }
//      System.out.println(Arrays.toString(flightsPerAirport.toArray()));
        return flightsPerAirport;
    }
}