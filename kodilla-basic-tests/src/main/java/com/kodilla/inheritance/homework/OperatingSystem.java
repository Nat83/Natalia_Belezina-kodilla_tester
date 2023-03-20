package com.kodilla.inheritance.homework;

public class OperatingSystem {
    private int publicationYear;

    public OperatingSystem(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void turnOn() {
        System.out.println("Operating system is switched on.");
    }

    public void turnOff() {
        System.out.println("Operating system is switched off.");
    }
}