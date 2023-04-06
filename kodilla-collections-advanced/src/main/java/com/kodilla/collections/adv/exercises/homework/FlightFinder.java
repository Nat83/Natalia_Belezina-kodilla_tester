package com.kodilla.collections.adv.exercises.homework;

import java.util.*;

public class FlightFinder {

    public List<Flight> findFlightsFrom(String departure) {
        List<Flight> flightsListDepartures = new ArrayList<>();
            if (Flight.getDeparture().equals(departure)){
                flightsListDepartures.add(new Flight(Flight.getDeparture(),Flight.getArrival()));
    }
        return flightsListDepartures;
    }

    public List<Flight> findFlightsTo(String arrival) {
        List<Flight> flightsListArrivals = new ArrayList<>();
            if (Flight.getArrival().equals(arrival)){
            flightsListArrivals.add(new Flight(Flight.getDeparture(),Flight.getArrival()));
        }
        return flightsListArrivals;
    }
}