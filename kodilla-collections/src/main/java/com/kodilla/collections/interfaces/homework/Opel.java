package com.kodilla.collections.interfaces.homework;

public class Opel implements Car {
    private int speed;
    private final String name = "Opel";

    public Opel(int speed) {
        this.speed = speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int increaseSpeed() {
        speed = speed + 60;
        return speed;
    }

    @Override
    public int decreaseSpeed() {
        speed = speed - 20;

        return speed;
    }

    public String getName() {
        return name;
    }
}
