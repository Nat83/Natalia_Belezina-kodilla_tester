package com.kodilla.collections.adv.exercises.homework;

import java.util.*;

public class FlightRepository {
     static Map<Airport, List<Flight>> flightRepositoryMap = new HashMap<>();
    public static List<Flight> getFlightsTable(Airport airport) {

        Flight flight = new Flight("WARSAW", "WROCLAW");
        Flight flight2 = new Flight("WARSAW", "KRAKOW");
        Flight flight3 = new Flight("WARSAW", "LODZ");
        Flight flight4 = new Flight("WROCLAW", "KATOWICE");
        Flight flight5 = new Flight("KATOWICE", "WROCLAW");
        Flight flight6 = new Flight("WROCLAW", "WARSAW");

        List<Flight> warsawFlightList = new ArrayList<>();
        warsawFlightList.add(flight);
        warsawFlightList.add(flight2);
        warsawFlightList.add(flight3);
        warsawFlightList.add(flight6);
        System.out.println("Warsaw list: " + warsawFlightList);

        List<Flight> wroclawFlightList = new ArrayList<>();
        wroclawFlightList.add(flight);
        wroclawFlightList.add(flight4);
        wroclawFlightList.add(flight5);
        wroclawFlightList.add(flight6);
        System.out.println("Wroclaw list: " + wroclawFlightList);

        List<Flight> lodzFlightList = new ArrayList<>();
        lodzFlightList.add(flight3);
        System.out.println("Lodz list: " + lodzFlightList);

        List<Flight> katowiceFlightList = new ArrayList<>();
        katowiceFlightList.add(flight4);
        katowiceFlightList.add(flight5);
        System.out.println("Katowice list: " + katowiceFlightList);

        List<Flight> krakowFlightList = new ArrayList<>();
        krakowFlightList.add(flight2);
        System.out.println("Krakow list: " + krakowFlightList);


        flightRepositoryMap.put(Airport.WARSAW, warsawFlightList);
        flightRepositoryMap.put(Airport.WROCLAW, wroclawFlightList);
        flightRepositoryMap.put(Airport.LODZ, lodzFlightList);
        flightRepositoryMap.put(Airport.KATOWICE, katowiceFlightList);
        flightRepositoryMap.put(Airport.KRAKOW,krakowFlightList);

        for (Map.Entry<Airport, List<Flight>> tableRecord : flightRepositoryMap.entrySet()) {
            List<Flight> flightListPerAirport = new ArrayList<>();

            if (tableRecord.getKey().equals(airport)){
                flightListPerAirport = tableRecord.getValue();
            }
        }
        return flightRepositoryMap.getOrDefault(airport,Collections.emptyList());
    }
}