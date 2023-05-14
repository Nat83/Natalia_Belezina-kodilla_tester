package com.kodilla.spring.basic.spring_configuration.homework;

import java.time.LocalTime;

public class DefaultCar implements Car {

    @Override
    public boolean hasHeadlightsTurnedOn(LocalTime hourFrom, LocalTime hourTo)
    {
        return false;
    }

    @Override
    public String getCarType() {
        return "Default";
    }
}
