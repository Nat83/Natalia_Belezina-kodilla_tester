package com.kodilla.collections.interfaces.homework;

public class Toyota implements Car {

    private final String name = "Toyota";
    private int speed;

    public Toyota(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int increaseSpeed() {
        speed = speed + 40;
        return speed;
    }

    @Override
    public int decreaseSpeed() {
        speed = speed - 10;
        return speed;
    }

    public String getName() {
        return name;
    }
}
