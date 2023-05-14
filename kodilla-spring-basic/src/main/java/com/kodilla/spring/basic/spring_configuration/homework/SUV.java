package com.kodilla.spring.basic.spring_configuration.homework;

import java.time.LocalTime;

public class SUV implements Car{
    @Override
    public boolean hasHeadlightsTurnedOn(LocalTime hourFrom, LocalTime hourTo) {
        if(hourFrom.isAfter(LocalTime.parse("19:59:59")) && hourTo.isBefore(LocalTime.parse("06:00:01")))
            return true;
        else
            return false;
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}
