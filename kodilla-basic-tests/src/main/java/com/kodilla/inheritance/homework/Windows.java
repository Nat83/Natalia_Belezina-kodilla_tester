package com.kodilla.inheritance.homework;

public class Windows extends OperatingSystem {

    public Windows(int publicationYear) {
        super(publicationYear);
    }

    @Override
    public void turnOn() {
        System.out.println("Windows is switched on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Windows is switched off.");
    }
}