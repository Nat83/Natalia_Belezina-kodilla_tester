package com.kodilla.inheritance.homework;

public class Linux extends OperatingSystem {

    public Linux(int publicationYear) {
        super(publicationYear);
    }

    @Override
    public void turnOn() {
        System.out.println("Linux is switched on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Linux is switched off.");
    }
}