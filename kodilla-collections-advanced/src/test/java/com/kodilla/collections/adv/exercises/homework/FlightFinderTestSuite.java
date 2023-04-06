package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FlightFinderTestSuite {
    FlightFinder flightFinder;
    @BeforeEach
    public void setUp (){
        flightFinder = new FlightFinder();
    }

    @Test
    public void canFindFlightsByDeparture(){

        System.out.println(flightFinder.findFlightsFrom("WARSAW"));
    }



}