package com.kodilla.collections.interfaces.homework;

public class Ford implements Car {
    private int speed;
    private final String name = "Ford";


    public Ford(int speed) {
        this.speed = speed;
    }


    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int increaseSpeed() {
        speed = speed + 50;
        return speed;
    }

    @Override
    public int decreaseSpeed() {
        speed = speed - 30;
        return speed;
    }

    public String getName() {
        return name;
    }
}
