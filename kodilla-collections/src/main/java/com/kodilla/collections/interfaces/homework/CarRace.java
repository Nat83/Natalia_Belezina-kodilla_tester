package com.kodilla.collections.interfaces.homework;

public class CarRace {
    public static void main(String[] args) {

        Ford ford = new Ford(0);
        Opel opel = new Opel(0);
        Car toyota = new Toyota(0);

        doRace(ford);
        doRace(opel);
        doRace(toyota);
    }

    private static void doRace(Car car) {
        System.out.println(car.getName() + " race speeds are: ");
        System.out.println(car.increaseSpeed());
        System.out.println(car.increaseSpeed());
        System.out.println(car.increaseSpeed());
        System.out.println(car.decreaseSpeed());
        System.out.println(car.decreaseSpeed());
        System.out.println(car.getSpeed());
    }
}
