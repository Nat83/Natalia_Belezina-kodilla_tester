package com.kodilla.collections.adv.exercises.homework;

import java.util.*;

public class FlightFinder {

    static Map<String, List<Flight>> flightRepositoryMap = new HashMap<>();

    public FlightFinder() {
        flightRepositoryMap.put("WROCLAW", FlightRepository.getFlightsTable("WROCLAW"));
        flightRepositoryMap.put("WARSAW", FlightRepository.getFlightsTable("WARSAW"));
        flightRepositoryMap.put("KATOWICE", FlightRepository.getFlightsTable("KATOWICE"));
        flightRepositoryMap.put("LODZ", FlightRepository.getFlightsTable("LODZ"));
    }

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        flightFinder.findFlightsFrom("WARSAW");
        flightFinder.findFlightsTo("WARSAW");
    }

    public List<Flight> findFlightsFrom(String departure) {
        List<Flight> allFlightsFromDepartureAirport = flightRepositoryMap.getOrDefault(departure, Collections.emptyList());
        List<Flight> flightsFrom = new ArrayList<>();
        for (Flight f : allFlightsFromDepartureAirport) {
            if (f.getDeparture() == departure) {
                flightsFrom.add(f);
            }
        }
        System.out.println(Arrays.toString(flightsFrom.toArray()));
        return flightsFrom;
    }

    public List<Flight> findFlightsTo(String arrival) {
        List<Flight> allFlightsFromArrivalAirport = flightRepositoryMap.getOrDefault(arrival, Collections.emptyList());
        List<Flight> flightsTo = new ArrayList<>();
        for (Flight f : allFlightsFromArrivalAirport) {
            if (f.getArrival() == arrival) {
                flightsTo.add(f);
            }
        }
        System.out.println(Arrays.toString(flightsTo.toArray()));
        return flightsTo;
    }
}