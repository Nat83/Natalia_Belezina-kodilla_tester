package com.kodilla.inheritance.homework;

public class OperatingSystemApp {
    public static void main(String[] args) {
        OperatingSystem operatingSystem = new OperatingSystem(2000);
        Linux linux = new Linux(2016);
        Windows windows = new Windows(2022);

        turnOnAndOff(operatingSystem);
        turnOnAndOff(windows);
        turnOnAndOff(linux);
    }

    private static void turnOnAndOff(OperatingSystem operatingSystem) {
        operatingSystem.turnOn();
        operatingSystem.turnOff();
    }
}



