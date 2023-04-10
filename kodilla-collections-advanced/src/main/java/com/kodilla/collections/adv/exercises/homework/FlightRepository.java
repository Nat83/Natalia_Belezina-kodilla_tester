package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlightRepository {

    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        flightRepository.getFlightsTable("GDANSK");
    }

    public static List<Flight> getFlightsTable(String airport) {

        Flight flight = new Flight("WARSAW", "WROCLAW");
        Flight flight2 = new Flight("WARSAW", "KRAKOW");
        Flight flight3 = new Flight("WARSAW", "LODZ");
        Flight flight4 = new Flight("WROCLAW", "KATOWICE");
        Flight flight5 = new Flight("KATOWICE", "WROCLAW");
        Flight flight6 = new Flight("WROCLAW", "WARSAW");

        List<Flight> allFlights = new ArrayList<>();
        allFlights.add(flight);
        allFlights.add(flight2);
        allFlights.add(flight3);
        allFlights.add(flight4);
        allFlights.add(flight5);
        allFlights.add(flight6);

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